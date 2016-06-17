package main

import (
	"flag"
	"fmt"
	"log"
	"os"
	"path/filepath"
)

var pattern string

func init() {
	flag.StringVar(&pattern, "pattern", "tmp", "directory to remove all the files")
	flag.Parse()
}

func main() {
	files, err := filepath.Glob(pattern)

	if err != nil {
		log.Fatal(err)
	}

	if len(files) == 0 {
		fmt.Println("No files to delete.")
		os.Exit(0)
	}

	fmt.Printf("fastrm will delete %d files matching %s.\n", len(files), pattern)

	for _, file := range files {
		dir, err := os.Stat(file)
		if err != nil {
			if dir.IsDir() {
				err = os.RemoveAll(file)
			} else {
				err = os.Remove(file)
			}
			if err != nil {
				log.Fatal(err)
			}
		}

		fmt.Printf("%s DELETED\n", file)
	}

	fmt.Printf("Done!")
}
