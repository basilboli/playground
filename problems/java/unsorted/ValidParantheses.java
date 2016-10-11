package problems;

import java.util.HashSet;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 28/08/15
 */
public class ValidParantheses {

  // for given valid combination s
  // inserts '(' or ')' at position pos and returns valid
  // runs in constant time
  public static String insertAt (String s, String p, int pos) {
    return s.substring(0, pos) + p +  s.substring(pos, s.length());
  }

  // for given valid combination s
  // inserts '(' or ')' at position pos and returns valid
  // runs in constant O(lengthOfs)
  public static String getValidCombination (String s) { //

    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')')
        sum--;
      else
        sum++;

      if (sum < 0)
        return  s.substring(0, i) + "(" + s.substring(i, s.length());
    }

    if (sum == 0) // ok string
      return s;
    if (sum == 1) // lacking one parantheses
      return s + ")";
    else // not valid string
      return "NOT VALID";
  }


  public static HashSet<String> genParantheses (int n) {

    HashSet<String> validCombinationsForN = new HashSet<String>();

    if (n == 1) {
      validCombinationsForN.add("()");
      return validCombinationsForN;
    }

    // use previous step valid combinations to generate new ones
    for (String c : genParantheses(n-1)) {
      for (int i = 0; i < c.length(); i++) {
        String newStr = insertAt(c, ")", i);
        validCombinationsForN.add(getValidCombination(newStr));
        newStr = insertAt(c, "(", i);
        validCombinationsForN.add(getValidCombination(newStr));
      }
    }

    for (String s : validCombinationsForN) {
      System.out.println(s);
    }
    // let's iterate over combinations and insert
    return validCombinationsForN;

  }

  public static void main(String[] args) {
    genParantheses(10);
  }
}
