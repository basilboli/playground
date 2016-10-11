package strings;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 08/10/15
 */
public class Palindrom {

  public static boolean isPalindrom(String s) {

    int i = 0, n = s.length(), j = n - 1, middle = n / 2;

    while (i < middle && j >= middle) {

      while (!isAlpha(s.charAt(i)) && i < middle)
        i++;

      while (!isAlpha(s.charAt(j)) && j >= middle)
        j--;

      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }

    }
    return true;
  }

  public static boolean isAlpha(char c) {
    return c >= 'A' && c <= 'z';
  }

  public static void main(String[] args) {
    System.out.println("ABBA:" + isPalindrom("ABBA"));
    System.out.println("ABDBA:" + isPalindrom("ABDBA"));
    System.out.println("DABDBAD:" + isPalindrom("DABDBAD"));
    System.out.println("DADBAD:" + isPalindrom("DADBAD"));
    System.out.println("!AB?BA!? :" + isPalindrom("!AB?BA!?"));
    System.out.println("!!?$!?:" + isPalindrom("!!?$!?"));
    System.out.println("!!?5432529123$!?:" + isPalindrom("!!?5432529123$!?:"));
    System.out.println("!!?543252D9123$!?:" + isPalindrom("!!?543252D9123$!?:"));
  }
}
