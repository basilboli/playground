package bitwise;

/**
 * Write a function to determine the number of bits required to convert integer A to integer B.
 * EXAMPLE Input: 31,14 Output: 2
 */
public class ConvertOneToAnotherChangingBits {

  public static int bitSwapRequired(int a, int b) {

    int count = 0;
    System.out.println("a ^ b = " + Integer.toBinaryString(a ^ b ));
    for (int c = a ^ b; c != 0; c = c >> 1) {
      System.out.println("c = " + Integer.toBinaryString(c));
      count += c & 1;
      System.out.println("count = " + count);
    }
    return count;
  }


  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(31));
    System.out.println(Integer.toBinaryString(14));
    System.out.println(bitSwapRequired(31, 14));
  }
}
