package models

import (
	"errors"
	"log"
	"strconv"

	"github.com/mediocregopher/radix.v2/pool"
	"github.com/mediocregopher/radix.v2/redis"
)

var db *pool.Pool

func init() {
	var err error
	db, err = pool.New("tcp", "localhost:6379", 10)
	if err != nil {
		log.Panic(err)
	}
}

var ErrNoAlbum = errors.New("models: no album found")

type Album struct {
	Title  string
	Artist string
	Price  float64
	Likes  int
}

func populateAlbum(reply map[string]string) (*Album, error) {
	var err error
	ab := new(Album)
	ab.Title = reply["title"]
	ab.Artist = reply["artist"]
	ab.Price, err = strconv.ParseFloat(reply["price"], 64)
	if err != nil {
		return nil, err
	}
	ab.Likes, err = strconv.Atoi(reply["likes"])
	if err != nil {
		return nil, err
	}
	return ab, nil
}

func FindAlbum(id string) (*Album, error) {
	log.Printf("Get album by id %s", id)
	reply, err := db.Cmd("HGETALL", "album:"+id).Map()
	if err != nil {
		return nil, err
	} else if len(reply) == 0 {
		return nil, ErrNoAlbum
	}

	return populateAlbum(reply)
}

func IncrementLikes(id string) error {
	conn, err := db.Get()
	if err != nil {
		return err
	}
	defer db.Put(conn)

	exists, err := conn.Cmd("EXISTS", "album:"+id).Int()
	if err != nil {
		return err
	} else if exists == 0 {
		return ErrNoAlbum
	}

	err = conn.Cmd("MULTI").Err
	if err != nil {
		return err
	}
	err = conn.Cmd("HINCRBY", "album:"+id, "likes", 1).Err
	if err != nil {
		return err
	}
	// And we do the same with the increment on our sorted set.
	err = conn.Cmd("ZINCRBY", "likes", 1, id).Err
	if err != nil {
		return err
	}

	err = conn.Cmd("EXEC").Err
	if err != nil {
		return err
	}
	return nil
}

func FindTopThree() ([]*Album, error) {
	conn, err := db.Get()
	if err != nil {
		return nil, err
	}
	defer db.Put(conn)

	// Begin an infinite loop.
	for {
		// Instruct Redis to watch the likes sorted set for any changes.
		err = conn.Cmd("WATCH", "likes").Err
		if err != nil {
			return nil, err
		}

		// Use the ZREVRANGE command to fetch the album ids with the highest
		// score (i.e. most likes) from our 'likes' sorted set. The ZREVRANGE
		// start and stop values are zero-based indexes, so we use 0 and 2
		// respectively to limit the reply to the top three. Because ZREVRANGE
		// returns an array response, we use the List() helper function to
		// convert the reply into a []string.
		reply, err := conn.Cmd("ZREVRANGE", "likes", 0, 2).List()
		if err != nil {
			return nil, err
		}

		// Use the MULTI command to inform Redis that we are starting a new
		// transaction.
		err = conn.Cmd("MULTI").Err
		if err != nil {
			return nil, err
		}

		// Loop through the ids returned by ZREVRANGE, queuing HGETALL
		// commands to fetch the individual album details.
		for _, id := range reply {
			err := conn.Cmd("HGETALL", "album:"+id).Err
			if err != nil {
				return nil, err
			}
		}

		// Execute the transaction. Importantly, use the Resp.IsType() method
		// to check whether the reply from EXEC was nil or not. If it is nil
		// it means that another client changed the WATCHed likes sorted set,
		// so we use the continue command to re-run the loop.
		ereply := conn.Cmd("EXEC")
		if ereply.Err != nil {
			return nil, err
		} else if ereply.IsType(redis.Nil) {
			continue
		}

		// Otherwise, use the Array() helper function to convert the
		// transaction reply to an array of Resp objects ([]*Resp).
		areply, err := ereply.Array()
		if err != nil {
			return nil, err
		}

		// Create a new slice to store the album details.
		abs := make([]*Album, 3)

		// Iterate through the array of Resp objects, using the Map() helper
		// to convert the individual reply into a map[string]string, and then
		// the populateAlbum function to create a new Album object
		// from the map. Finally store them in order in the abs slice.
		for i, reply := range areply {
			mreply, err := reply.Map()
			if err != nil {
				return nil, err
			}
			ab, err := populateAlbum(mreply)
			if err != nil {
				return nil, err
			}
			abs[i] = ab
		}

		return abs, nil
	}
}
