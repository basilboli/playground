package main

import (
	"fmt"
)

var x uint8 = 1<<1 | 1<<5
var y uint8 = 1<<1 | 1<<2
var z int64 = 17

func main() {
	fmt.Printf("%08b\n", x)
	fmt.Printf("%08b\n", y)
	fmt.Printf("%064b\n", z)
	fmt.Printf("%d %[1]o %#[1]o\n", z)
}
