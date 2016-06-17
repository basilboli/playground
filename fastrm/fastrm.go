package main

import (
	"flag"
	"fmt"
	"io/ioutil"
	"log"
	"os"
)

var dir, pattern string

func init() {
	flag.StringVar(&dir, "dir", "tmp", "directory to remove all the files")
	flag.StringVar(&pattern, "pattern", "pattern", "file pattern example log")
	flag.Parse()
}

func askForConfirmation() bool {
	var response string
	_, err := fmt.Scanln(&response)
	if err != nil {
		log.Fatal(err)
	}
	if "yes" == response {
		return true
	} else if "no" == response {
		return false
	} else {
		fmt.Println("Please type yes or no and then press enter:")
		return askForConfirmation()
	}
}

func main() {
	files, err := ioutil.ReadDir(dir)

	if err != nil {
		log.Fatal(err)
	}

	if len(files) == 0 {
		fmt.Println("No files to delete.")
		os.Exit(0)
	}

	fmt.Printf("fastrm will delete files from %s matching %s.\n", dir, pattern)
	fmt.Println("Please type yes or no and then press enter:")

	ok := askForConfirmation()

	if !ok {
		os.Exit(0)
	}

	for _, file := range files {
		err = os.Remove(fmt.Sprintf("%s/%s", dir, file.Name()))
		if err != nil {
			log.Fatal(err)
		}
		fmt.Printf("%s DELETED\n", file.Name())
	}

	// err = os.RemoveAll(dir)

	// if err != nil {
	// 	log.Fatal(err)
	// }
	fmt.Printf("Done!")
}
