package main

import (
	"flag"
	"fmt"
	"log"
	"os"
	"path/filepath"
)

var pattern string

func Remove(pattern string) {
	files, err := filepath.Glob(pattern)

	if err != nil {
		log.Fatal(err)
	}

	for _, file := range files {
		dir, err := os.Stat(file)
		if err == nil {
			if dir.IsDir() {
				err = os.RemoveAll(file)
			} else {
				err = os.Remove(file)
			}
			if err != nil {
				log.Fatal(err)
			}
			fmt.Printf("%s is DELETED\n", file)
		}
	}
}

func main() {
	flag.StringVar(&pattern, "pattern", "tmp", "files matching pattern example /usr/*/bin/fastrm ")
	flag.Parse()
	Remove(pattern)
	fmt.Println("Done.")
}
