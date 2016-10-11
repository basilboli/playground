public class ValidPalindrome {

	// O(n) runtime, O(1) space
	public static boolean isPalindrome (String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(""));
		System.out.println(isPalindrome("madamImadam"));
	}
}

