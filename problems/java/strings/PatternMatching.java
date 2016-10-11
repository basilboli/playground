package strings;

import static org.junit.Assert.assertEquals;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 23/10/15
 */
public class PatternMatching {

  public static int findMatch(String input, String pattern) {

    for (int i = 0; i <= input.length() - pattern.length(); i++) {
      for (int j = 0; j < pattern.length(); j++) {
        if (input.charAt(i + j) != pattern.charAt(j))
          break;
        if (j == pattern.length() - 1)
          return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {

    assertEquals(-1, findMatch("", ""));
    assertEquals(-1, findMatch("sdafds", ""));
    assertEquals(-1, findMatch("", "sdfadsf"));
    assertEquals(4,  findMatch("aabaabba", "abba"));
    assertEquals(1,  findMatch("aabbaabba", "abba"));
    assertEquals(-1, findMatch("aabaabaabababa", "abba"));
  }


}
