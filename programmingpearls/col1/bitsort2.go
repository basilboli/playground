// sort input at most n positive integers, each less than n, where n=10^7
// uses bitwise operations

package main

import (
	"bufio"
	"fmt"
	. "github.com/basilboli/playground/programmingpearls/common"
	"os"
	"strconv"
)

func main() {
	const MAX = 10000000
	var counts IntSet

	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		i, err := strconv.Atoi(input.Text())
		if err != nil {
			panic(err)
		}
		counts.Add(i)
	}

	for i := 0; i < MAX; i++ {
		if counts.Has(i) {
			fmt.Println(i)
		}
	}
}
