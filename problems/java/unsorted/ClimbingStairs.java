public class ClimbingStairs {

	// how many distinct ways can you climb to the top
	public static int fib(int n) {

		int n2 = 1, n1 = 1;
		for (int i = 2; i <= n; i++) {
			int temp = n1;
			n1 += n2;
			n2 = temp;
		}
		return n1;
	}

	public static void main(String[] args) {
		assert ClimbingStairs.fib(2) == 2;
		assert ClimbingStairs.fib(3) == 3;
		assert ClimbingStairs.fib(4) == 5;
		assert ClimbingStairs.fib(5) == 8;
	}

}

