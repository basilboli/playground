package combinatorics;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 11/02/16
 */
public class GenerateAllSubsets {
  //  final int NMAX = 2147483646;
  final static int NMAX = 100;

  void generate(int n) {

    int [] a = new int[NMAX]; // solution vector
    backtrack(a, 0, n);
  }

  int constructCandidates (int a [], int k, int n, int c[])  {

    int ncandidates = 2;
    c[0] = 1;
    c[1] = 0;
    return ncandidates;

  }

  void backtrack (int a [], int k, int n)  {
    int c[] = new int[n]; // candidates for next position
    int ncandidates;      // next position candidate count
    int i;                //counter

    if (isSolution(a, k, n)) {
      processSolution(a, k);
    }
    else {
      k = k + 1;
      ncandidates = constructCandidates(a, k, n, c);
      for (i = 0; i < ncandidates; i++) {
        a[k] = c[i];
        backtrack(a, k, n);
      }
    }
  }

  void processSolution (int [] a, int k) {

    System.out.printf("{");
    for (int i = 1; i <=k ; i++) {

      if (a[i] == 1) {
        System.out.printf("%d", i);
      }
    }
    System.out.printf("}\n");
  }

  boolean isSolution (int a[], int k, int n) {
    return (k == n);
  }


  public static void main(String[] args) {
    GenerateAllSubsets g = new GenerateAllSubsets();
    g.generate(NMAX - 1);
  }
}
