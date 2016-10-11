package codejam.qualificationafrica2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 10/04/15
 */
public class StoreCredit {

  public static void main(String[] args) throws IOException {
    BufferedReader is = new BufferedReader(
            new InputStreamReader(System.in));

    int cases = Integer.parseInt(is.readLine());

    for (int i = 1; i <= cases; i++) {
      // read amount of credit
      int c = Integer.parseInt(is.readLine());
      int ni = Integer.parseInt(is.readLine());
      String[] pr = is.readLine().split("\\s+");
      int[] prices = new int[pr.length];

      for (int j = 0; j < pr.length; j++) {
        prices[j] = Integer.parseInt(pr[j]);
      }
      int[] res = find(c, prices);
      System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
    }
  }

  private static int[] find(int sum, int[] prices) {
    for (int i = 0; i < prices.length; i++) {
      for (int j = 0; j < prices.length; j++) {
        if (i == j)
          continue;

        if (prices[i] + prices[j] == sum)
          return new int[]{i + 1, j + 1};

      }
    }

    return null;
  }
}
