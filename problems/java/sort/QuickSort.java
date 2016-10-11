import java.util.Arrays;


public class QuickSort {

  static void swap(int a[], int i, int j) {
    int tmp;
    tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }


  static void quicksort(int s[], int a, int b) {
    int p;
    if (b - a > 0) {
      p = partition(s, a, b);
      quicksort(s, a, p - 1);
      quicksort(s, p + 1, b);
    }
  }

  static int partition(int s[], int a, int b) {
    System.out.println("partitioning ...");
    System.out.printf("a : %s, b : %s \n", a, b);
    int i, pivot, firsthigh;
    pivot = b;
    System.out.println("pivot.value :" + s[pivot]);
    firsthigh = a;
    System.out.println("firsthigh.value :" + s[a]);
    System.out.println("s before partitioning:" + Arrays.toString(s));
    for (i = a; i < b; i++) {
      if (s[i] < s[pivot]) {
        swap(s, i, firsthigh);
        System.out.println(String.format("swapping %sth with %sth with %s with %s ", i, firsthigh, s[i], s[firsthigh]));
        System.out.println("s:" + Arrays.toString(s));
        firsthigh++;
      }
    }
    swap(s, pivot, firsthigh);
    System.out.println("s:" + Arrays.toString(s));
    System.out.println("Returning firsthigh:" + firsthigh);
    System.out.println("Returning firsthigh.value:" + s[firsthigh]);
    return firsthigh;
  }


  public static void main(String[] args) {
    int[] arr = new int[] {9, 7 , 5 , 11, 12, 2, 14, 3, 10, 6};
    quicksort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }
}
