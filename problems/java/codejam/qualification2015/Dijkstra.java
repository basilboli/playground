package codejam.qualification2015;

import java.io.IOException;
import java.util.*;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 11/04/15
 */
public class Dijkstra {


  static List charss = Arrays.asList(
          "1",
          "i",
          "j",
          "k"
  );

  static Map<String, Map<String, String>> quaternion = new HashMap<>();

  static {
    Map<String, String> row = new HashMap<>();
    row.put("1", "1");
    row.put("i", "i");
    row.put("j", "j");
    row.put("k", "k");

    quaternion.put("1", row);

    row = new HashMap<>();
    row.put("1", "i");
    row.put("i", "-1");
    row.put("j", "k");
    row.put("k", "-j");

    quaternion.put("i", row);

    row = new HashMap<>();
    row.put("1", "j");
    row.put("i", "-k");
    row.put("j", "-1");
    row.put("k", "i");

    quaternion.put("j", row);

    row = new HashMap<>();
    row.put("1", "k");
    row.put("i", "j");
    row.put("j", "-i");
    row.put("k", "-1");

    quaternion.put("k", row);

  }

  private static String find(int length, String str) {

    int iindex = -1, jindex = 0, kindex = str.length() + 1;

//    System.out.println("Treating :" + str);

    if (str.length() < 3)
      return "NO";

    // - Check if the full string resolves to -1, as ijk = -1
    String mult = "1";

    for (int i = 0; i < str.length(); i++) {
      String next = str.substring(i, i + 1);
      mult = multiply1x1(mult, next);
    }

//    System.out.println("string resolves to :" + mult);
    if (!"-1".equals(mult))
      return "NO";

    // Then, find the first/shortest i from the left

//    System.out.println("Looking for iindex ...");
    mult = "1";
    while (!"i".equals(mult) && iindex < str.length() - 1) {
      iindex++;
//      System.out.println("Trying " + iindex);
      mult = multiply1x1(mult, str.substring(iindex, iindex + 1));
    }
//    System.out.println("iindex is " + iindex);
//    System.out.println("i str is " + str.substring(0, iindex + 1));

    // Then, find the first/shortest k from the right
//    System.out.println("Looking for kindex ...");
    mult = "1";
    while (!"k".equals(mult) && kindex > iindex + 1) {
      kindex--;
//      System.out.println("Trying " + kindex);
      mult = multiply1x1(str.substring(kindex - 1, kindex), mult);
    }
//    System.out.println("kindex is " + kindex);
//    System.out.println("k str is " + str.substring(kindex, str.length()));

    // check j
    jindex = iindex + 1;
//    System.out.println("jindex is " + jindex);

//    System.out.println("j string is " + jStr);
    if ((iindex < jindex) && (jindex < kindex) && "j".equals(multiply(str.substring(jindex, kindex - 1)))) {
      return "YES";
    }

    return "NO";
  }

  private static String multiply(String str) {

    if (str.length() == 1)
      return str;

    String result = multiply1x1(str.substring(0, 1), str.substring(1, 2));
    for (int i = 1; i <= str.length() - 2; i++) {

      String next = str.substring(i + 1, i + 2);
      result = multiply1x1(result, next);
    }
    return result;
  }

  /**
   * doing 1x1 character multiplication
   *
   * @param a
   * @param b
   * @return
   */
  private static String multiply1x1(String a, String b) {
//    System.out.println("Mutliplying " + a + " and " + b);
    boolean positive = true;
    if (a.contains("-")) {
      positive = !positive;
      a = a.replace("-", "");
    }
    if (b.contains("-")) {
      positive = !positive;
      b = b.replace("-", "");
    }

    String result = quaternion.get(a).get(b);
    if (result.contains("-") && !positive) {
      return result.replace("-", "");

    }

    return positive ? result : "-" + result;
  }

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    int cases = scanner.nextInt();
    for (int i = 1; i <= cases; i++) {
      int length = scanner.nextInt();
      long repeats = scanner.nextLong();
      String line = scanner.next();
      StringBuffer str = new StringBuffer();
      for (long j = 0; j < repeats; j++) {
        str.append(line);
      }
      System.out.println("Case #" + i + ": " + find(length, str.toString()));
    }

  }


}
