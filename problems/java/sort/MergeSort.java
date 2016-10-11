import java.util.Arrays;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 31/08/15
 */
public class MergeSort {

  static int[] mergesort(int[] v) {

    if (v.length == 1)
      return v;

    int[] a = mergesort(Arrays.copyOfRange(v, 0, v.length / 2));
    int[] b = mergesort(Arrays.copyOfRange(v, v.length / 2, v.length));

    return merge(a, b);
  }

  static int[] merge(int[] a, int[] b) {
    int[] res = new int[a.length + b.length];

    // three pointers for every array
    int i = 0, j = 0, k = 0;

    while (k < res.length && i < a.length && j < b.length) {
      if (a[i] > b[j]) {
        res[k++] = b[j++];
      } else {
        res[k++] = a[i++];
      }
    }
    while (i < a.length) {
      res[k++] = a[i++];
    }
    while (j < b.length) {
      res[k++] = b[j++];
    }
    return res;
  }

  public static void main(String[] args) {

  }

}
