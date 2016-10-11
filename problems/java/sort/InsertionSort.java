package sort;

import java.util.Arrays;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 07/09/15
 */
public class InsertionSort {

  public static int [] insertionSort(int [] arr) {

    int i = 0;
    for (int j = 1; j < arr.length; j++) {
      int key = arr[j];
      i = j-1;
      while (i >= 0 && arr [i] > key) {
        arr[i+1] = arr[i] ;
        i--;
      }
      arr [i+1]  = key;
    }
    return arr;
  }

  public static void main (String [] args) {
//    int[] arr = new int[]{9, 7 , 5 , 11, 12, 2, 14, 3, 10, 6};
    int[] arr = new int[]{5, 2 ,4 , 6, 1, 3};
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
