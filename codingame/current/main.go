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

func shadocs(N int64) string {

	strBase4 := string(strconv.FormatInt(N, 4))
	var s string
	for _, v := range strBase4 {
		s = s + encodeShadoks(fmt.Sprintf("%c", v))
	}
	return s
}

func check(p bool) {
	if !p {
		panic("Failed")
	}
	fmt.Println("Ok")
}

func test() {
	check("BUGAGA" == shadocs(16))
	check("ZOGA" == shadocs(8))
	check("BUBU" == shadocs(5))
}

func main() {
	// test()
	var N int64
	fmt.Scan(&N)
	fmt.Println(shadocs(N))
}
