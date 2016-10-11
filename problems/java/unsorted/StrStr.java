import java.util.*;

/**
*  Implement strstr().
*  Returns the index of the first occurrence of needle in haystack, or –1
*  if needle is not part of haystack.
**/
public class StrStr {

	public static int strStrNaive(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}
		if (haystack.length() == 0) {
			return -1;
		}

		for (int i = 0; i < haystack.length() ; i++) {

			int j = 0, k = i;
			while (j < needle.length()
			        && k < haystack.length()
			        && haystack.charAt(k) == needle.charAt(j)) {
				j++;
				k++;
			}
			System.out.printf("j: %s\n", j);
			if (j == needle.length()) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		assert strStr("hello", "") == 0;
		assert strStr("", "hello") == -1;
		assert strStr("hello", "ll") == 2;
		assert strStr("hellohello", "he") == 0;
	}
}

