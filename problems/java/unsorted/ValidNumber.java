public class ValidNumber {

	public static boolean isValid(String s) {
		// reading  s1s2s3s4 :
			// s1=\s*
			// s2= +|-
			// s31=[0-9]*.{1}[0-9]*
			// s4=\s*
		int i = 0, n = s.length();

		// read s1
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		
		// read s2
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		
		// read s3
		boolean isNumeric = false;

		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}

		// read s4
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;

		return isNumeric && i == n;

	}

	public static void main(String[] args) {
		assert ValidNumber.isValid("1.1") == true;
		assert ValidNumber.isValid("1.a") == false;
		assert ValidNumber.isValid("+1.1") == true;
		assert ValidNumber.isValid(" +1.1 ") == true;
		assert ValidNumber.isValid(" -1.1 ") == true;
	}

}

