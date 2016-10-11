package codejam.qualificationafrica2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 10/04/15
 */
public class A {

  public static void main(String[] args) throws IOException {
    BufferedReader is = new BufferedReader(
            new InputStreamReader(System.in));

    int cases = Integer.parseInt(is.readLine());

    for (int i = 1; i <= cases; i++) {
      System.out.println("Case #" + i + ": " + reverse(is.readLine()));
    }
  }

  private static String reverse(String line) {
    String[] arr = line.split("\\s+");
    List<String> words = Arrays.asList(arr);
    Collections.reverse(words);

    StringBuffer result = new StringBuffer();
    for (int i = 0; i < words.size(); i++) {
      result.append(words.get(i));
      if (i <= words.size() - 1)
        result.append(" ");
    }
    return result.toString();
  }
}
