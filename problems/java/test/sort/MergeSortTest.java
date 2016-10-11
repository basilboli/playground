package sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {

  @Test
  public void testSort() throws Exception {

    assertEquals("[3, 4, 5, 6]",
            Arrays.toString(MergeSort.mergesort(new int[]{6, 5, 4, 3})));
    assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",
            Arrays.toString(MergeSort.mergesort(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
    assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]",
            Arrays.toString(MergeSort.mergesort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1})));


  }

}