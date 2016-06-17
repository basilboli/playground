package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"testing"
)

// CreateTestFiles creates n test files in directory
func CreateFiles(dir string, n int) {
	fmt.Println("creating test files ...")
	os.Mkdir(dir, 0777)
	for i := 0; i < n; i++ {
		file, err := ioutil.TempFile(dir, "")
		if err != nil {
			log.Fatal(err)
		}
		file.Close()
	}
	fmt.Println("%d files have been created!", n)
}

func TestBot(t *testing.T) {

	fmt.Println("testing fastrm ...")
	CreateFiles("test", 10000)
	// ListFiles(dir)
	// os.RemoveAll(dir)
}