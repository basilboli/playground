package main

import (
	"fmt"
	"strconv"
)

/**

The shadoks only know four words: GA, BU, ZO and MEU.
They use these four words to say the numbers.
For example:
0 is GA, 1 is BU, 2 is ZO and 3 is MEU.
4 is BUGA, 5 is BUBU, 8 is ZOGA, 16 is BUGAGA and so on.

 **/
func encodeShadoks(s string) string {
	switch s {
	case "0":
		return "GA"
	case "1":
		return "BU"
	case "2":
		return "ZO"
	case "3":
		return "MEU"
	}
	return ""
}

func reverse(s string) string {
	fmt.Println(strconv.FormatInt(i, base))
	return s
}

func check(p bool) {
	if !p {
		panic("Failed")
	}
	fmt.Println("Ok")
}

func test() {
	check(reverse("cdcd") == "cddc")
	// check(reverse("abcd") == "imp")
	// check(reverse("AABBaabb33!!??") == "!3?ABabbaBA?3!")
	// check("aa1aaaaaaa7aaaaaaaaaaaaaaa7aaaaaaaaaaaaaaaaaaaaa1aaaaaaaaaaaaaaaaaaaaaaa" == reverse("17aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa71"))
}

func main() {
	test()
	// var s string
	// fmt.Scan(&s)
	// fmt.Println(reverse(s))
}
