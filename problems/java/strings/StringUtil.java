import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 27/11/14
 */
public class StringUtil {

  /*
  reverse string
  */
  public static String reverse (String s) {
    char [] chars = s.toCharArray();
    int length = chars.length, last = length -1;
    for (int i = 0; i < length/2; i++) {
      char tmp = chars[i];
      chars[i] = chars[last-i];
      chars[last-i] = tmp;
    }
    return new String(chars);
  }


  /**
   * check if all characters are unique
   *
   * @return
   */
  public static boolean hasAllUniqueCharacters (String str) {
    HashMap <Character,Integer> hmap = new HashMap<>();
    for (Character ch : str.toCharArray())
      if (hmap.put(ch, 1) != null)
        return false;

    return true;
  }

  /**
   * check if all characters are unique
   * note : without hashmap datastructure
   *
   * @return
   */
  public static boolean hasAllUniqueCharacters2 (String str) {
    // TODO
    return true;
  }

  /**
   * @param s string to check for being palindrom
   * @return true if string is palindrom
   */
  public static boolean isPalindrom(String s) {

    char[] arr = s.toCharArray();
    int i = 0, j= s.length()-1;

    while (i < s.length()/2) {
      if (arr[i++] != arr[j--])
        return false;
    }

    return true;
  }


  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = "";
    try {
      str  = br.readLine();
    } catch (IOException e) {
      System.exit(1);
    }

  }
}
