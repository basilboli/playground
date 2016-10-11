import java.util.*;

/**
*  Implement reverseWords().
*  Given an input string s, reverse the string word by word.
*  Ignore trailing spaces
*  Reduce multiple spaces between words to one
*
**/
public class ReverseWords {

	// naive: two pass approach

	// better : one pass approach
	public static String reverseWords(String s) {

		StringBuilder reversed = new StringBuilder();
		int end = s.length();
		for (int start = s.length() - 1; start >= 0; start--) {
			if (s.charAt(start) == ' ') {
				end = start;
			} else if (start == 0 || s.charAt(start - 1) == ' ') {
				if (reversed.length() != 0) {
					reversed.append(' ');
				}
				reversed.append(s.substring(start, end));
			}
		}
		return reversed.toString();

	}

	// better : in-place
	// string does not contain leading or trailing spaces and the words are separated by a single space
	// idea : reverse (for w in words reverse(w))
	public static void reverseWordsInPlace(char[] s) {
		reverse(s, 0, s.length);

		for (int i = 0, j = 0; j <= s.length ; j++ ) {
			if (j == s.length  || s[j] == ' ') {
				reverse(s, i, j);
				i = j + 1;
			}
		}
	}

	public static void reverse (char[] s, int start, int end) {
		for (int i = 0; i < (end - start) / 2; i++ ) {
			char tmp = s[start + i];
			s[start + i] = s[end - i - 1];
			s[end - i - 1] = tmp;
		}

	}

	public static void test (String in, String exp) {
		char arr []  = in.toCharArray();
		reverseWordsInPlace(arr);
		String act = new String(arr);
		System.out.printf("in: %s, exp : %s, act : %s \n", in, exp, act);
		assert act.equals(exp);
	}

	public static void main(String[] args) {
		char[] s = "hello my friend".toCharArray();
		reverseWordsInPlace(s);
		System.out.println(s);

		s = "i love all of you".toCharArray();
		reverseWordsInPlace(s);
		System.out.println(s);

		// test("hello my friend", "friend my hello");
		// test("hello   my friend", "friend my hello");
		// test("  hello   my    friend  ", "friend my hello");
		// test("", "");
		// test("   ", "");
		// test("foo", "foo");
	}
}

