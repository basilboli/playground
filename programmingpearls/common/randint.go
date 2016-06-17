// program generates n random integers

package main

import (
	"fmt"
	"math/rand"
	"os"
	"strconv"
)

const (
	MAX = 10000000
)

func main() {

	n, err := strconv.Atoi(os.Args[1])
	if err != nil {
		panic(err)
	}

	for i := 0; i < n; i++ {
		fmt.Println(rand.Intn(MAX))
	}
}
