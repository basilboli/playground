package main

import "fmt"
import "os"
import "bufio"
import "strings"
import "strconv"

/**
Your program must print the steps of a binary search to find the number x in a sorted list l.

The binary search operates by comparing the middle element mid of the list with x.
If the length of the list is even, use the first among the 2 most centered elements

If x > mid, we continue the search in the top of the list, mid is now the bottom boundary (non inclusive) of this new list.
If x < mid, we continue the search in the bottom of the list, mid is now the top boundary (non inclusive) of this new list.
If x = mid, we stop the search.

At each step, print the new bottom or top boundary.
**/

func binary(x int64, arr []int64) {
	// fmt.Printf("Looking for %v in %v \n", x, arr)
	lbound := 0
	rbound := len(arr)
	i, max := 0, 10
	mid := (rbound - lbound) / 2
	var steps []string
	for i < max {
		// fmt.Printf("mid: %v, lbound : %v, rbound : %v\n", mid, lbound, rbound)
		steps = append(steps, strconv.Itoa(mid))
		if x == arr[mid] {
			break
		}
		if x > arr[mid] {
			// fmt.Printf("lbound %v=>%v\n", lbound, mid)
			lbound = mid
			mid = lbound + (rbound-lbound)/2
		} else {
			// fmt.Printf("rbound %v=>%v\n", rbound, mid)
			rbound = mid
			mid = rbound - (rbound-lbound)/2
		}
		i++
	}
	fmt.Println(strings.Join(steps, " "))
}

func check(p bool) {
	if !p {
		panic("Failed")
	}
	fmt.Println("Ok")
}

func test() {
	fmt.Println("Copy paste this")
	fmt.Println("4")
	fmt.Println("7")
	fmt.Println("0 1 2 3 4 5 6")
}

func main() {
	go test()
	scanner := bufio.NewScanner(os.Stdin)

	var x int64
	scanner.Scan()
	fmt.Sscan(scanner.Text(), &x)

	var n int
	scanner.Scan()
	fmt.Sscan(scanner.Text(), &n)

	scanner.Scan()
	inputs := strings.Split(scanner.Text(), " ")
	arr := make([]int64, len(inputs))

	for i := 0; i < n; i++ {
		v, err := strconv.ParseInt(inputs[i], 10, 32)
		if err != nil {
			panic("Problem")
		}
		arr[i] = v
	}
	binary(x, arr)
}
