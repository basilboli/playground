// sort input at most n positive integers, each less than n, where n=10^7
// uses array of integers where v[i] = 1 if integer i is present in the array

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

const MAX = 10000000

func main() {
	counts := make([]int, MAX)

	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		i, err := strconv.ParseInt(input.Text(), 10, 64)
		if err != nil {
			panic(err)
		}
		counts[i] = 1
	}

	for i := 0; i < MAX; i++ {
		if counts[i] == 1 {
			fmt.Println(i)
		}
	}
}
