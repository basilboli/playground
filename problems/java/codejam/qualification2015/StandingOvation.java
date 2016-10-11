package codejam.qualification2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 11/04/15
 */
public class StandingOvation {
  public static void main(String[] args) throws IOException {
    BufferedReader is = new BufferedReader(
            new InputStreamReader(System.in));

    int cases = Integer.parseInt(is.readLine());

    for (int i = 0; i < cases; i++) {
      // read input smax digitArray
      String [] l = is.readLine().split("\\s+");
      int N = Integer.parseInt(l[0]);
      char[] digitArray = l[1].toCharArray();
      int [] d = new int[digitArray.length];
      for (int j = 0; j < digitArray.length; j++) {
          d[j] = Character.getNumericValue(digitArray[j]);
      }
      System.out.println("Case #" + (i +1) +  ": " + find(N, d));
    }
  }

  private static int find(int N, int[] d) {

    int total = 0, numFriends = 0;

    for (int i = 0; i <=N; i++) {

      if (d[i] > 0 && total < i) {
        numFriends += i - total;
        total = i;
      }
      total += d[i];
    }
    return numFriends;
  }
}
