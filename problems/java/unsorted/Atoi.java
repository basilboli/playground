public class Atoi {

	private static final int maxDiv10 = Integer.MAX_VALUE / 10;

	// ignore whitespace chars till first non-whitespace is found
	// parse sign of the number
	// if no conversion is possible return 0
	// if number is out of range return INT_MAX or INT_MIN

	public static int myAtoi(String s) {

		int i = 0, n = s.length(), sign = 1 ;

		while (i < n && s.charAt(i) == ' ') {
			i++;
		}
		
		if (i < n && s.charAt(i) == '-') {
			sign = -1 ;
			i++;
		} else if (i < n && s.charAt(i) == '+') {
			sign = 1 ;
			i++;
		}

		int num = 0;
		while (i < n && Character.isDigit(s.charAt(i))) {
			int digit = Character.getNumericValue(s.charAt(i));
			if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}

		return sign * num;
	}

	public static void main(String[] args) {
		assert Atoi.myAtoi("234") == 234;
		assert Atoi.myAtoi("-234") == -234;
		assert Atoi.myAtoi("") == 0;
		assert Atoi.myAtoi("abs") == 0; // invalid
		assert Atoi.myAtoi("       ") == 0;
		assert Atoi.myAtoi("  234") == 234;
		assert Atoi.myAtoi("2147483647") == 2147483647;
		assert Atoi.myAtoi("-2147483648") == -2147483648;
		assert Atoi.myAtoi("2147483648") == 2147483647; // truncate
	}

}

