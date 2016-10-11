package combinatorics;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 11/02/16
 */
public class GenerateAllPermutations {

//  final int NMAX = 2147483646;
  final static int NMAX = 3;

  void generate(int n) {

    int [] a = new int[NMAX]; // solution vector
    backtrack(a, 0, n);
  }

  int constructCandidates (int a [], int k, int n, int c[])  {

    int i, ncandidates; // counter
    boolean [] in_perm = new boolean[NMAX]; // who is in permutation

//    for (i = 1; i < NMAX; i++) in_perm[i] = false;
    for (i = 0; i < k; i++) in_perm[a[i]] = true;

    ncandidates = 0;

    for (i = 1; i <=n ; i++) {
      if (!in_perm[i]) {
        c[ncandidates] = i;
        ncandidates++;
      }
    }
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
    for (int i = 1; i <=k ; i++) {
      System.out.printf("%d", a[i]);
    }
    System.out.printf("\n");
  }

  boolean isSolution (int a[], int k, int n) {
    return (k == n);
  }


  public static void main(String[] args) {
    GenerateAllPermutations g = new GenerateAllPermutations();
    g.generate(NMAX - 1);
  }
}
