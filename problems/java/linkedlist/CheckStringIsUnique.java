package linkedlist;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 06/09/15
 */
public class CheckStringIsUnique {

  public static boolean isUniqueChars2(String str) {

    //  in case we can use additional data structures

    Map<Character, Integer> charsMap = new HashMap<>();

    char [] arr = str.toCharArray();
    for (char anArr : arr) {

      if (charsMap.containsKey(anArr))
        return false;

      charsMap.put(anArr, 1);
    }

    return true;

  }

  public static boolean isUniqueChars(String str) {
    if (str.length() > 128) {
      return false;
    }
    int checker = 0;
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i) - 'a';
      System.out.println(Integer.toBinaryString(checker));
      if ((checker & (1 << val)) > 0) return false;
      checker |= (1 << val);
    }
    return true;
  }

  public static void main(String[] args) {

//    Assert.check(isUniqueChars("abcd"));
    Assert.check(!isUniqueChars("abca"));
//    Assert.check(isUniqueChars("abcdefghilmnopqrstuvwxyz"));
//    Assert.check(!isUniqueChars("abcdefghilmnopqrstuvwxyza"));

  }
}
