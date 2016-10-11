package hackrank;

import java.util.Scanner;

public class DiagSums {


  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int [][] m = new int[n] [n];

    int sum1 = 0, sum2 = 0;
    for (int i=0; i < n; i++)
      for (int j=0; j < n; j++)
        if (i==j)
          sum1=in.nextInt();
        else if (i+j==n)
          sum2+=in.nextInt();
        else
          in.nextInt();

    System.out.println(Math.abs(sum1 - sum1));
  }
}