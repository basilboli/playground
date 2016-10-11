package bitwise;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 20/09/15
 */
public class Calculator {

  /**
   * gets i bit of the number
   * <p/>
   * num & (1 << i) ! = 0
   */
  public static boolean getBit(int num, int i) {
    int tmp = 1 << i;
    System.out.println(Integer.toBinaryString(tmp));
    tmp = num & tmp;
    System.out.println(Integer.toBinaryString(tmp));
    return (tmp != 0);
  }

  /**
   * sets i bit of the number
   * <p/>
   * num | (1 << i)
   */
  public static int setBit(int num, int i) {
    int tmp = 1 << i;
    System.out.println(Integer.toBinaryString(tmp));
    tmp = num | tmp;
    System.out.println(Integer.toBinaryString(tmp));
    return tmp;
  }

  /**
   * clears i bit of the number
   * <p/>
   * num & ~(1 << i)
   */
  public static int clearBit(int num, int i) {
    int tmp = ~(1 << i);
    System.out.println(Integer.toBinaryString(tmp));
    tmp = num & tmp;
    System.out.println(Integer.toBinaryString(tmp));
    return tmp;
  }

  /**
   * clears bits i through0
   * <p/>
   * num & ~((1 << (i+1)) - 1)
   */
  public static int clearBitsIthrough0(int num, int i) {
    int tmp = ~((1 << (i + 1)) - 1);
    System.out.println(Integer.toBinaryString(tmp));
    tmp = num & tmp;
    System.out.println(Integer.toBinaryString(tmp));
    return tmp;
  }

  int updateBit(int num, int i, int v) {
    int mask = ~(1 << i);
    return (num & mask) | (v << i);
  }


  public static void main(String[] args) {
    int num = 1000;
    System.out.println("x = " + num);
    System.out.println("x = " + Integer.toBinaryString(num));
//    System.out.println("x ^ 0 = " + Integer.toBinaryString(i ^ 0));
//    System.out.println("x ^ 0 = " + (i ^ 0));
//    System.out.println("x ^ 1 = " + Integer.toBinaryString(i ^ 1));
//    System.out.println("x ^ 1 = " + (i ^ 1));
//    System.out.println("~x = " + ~i);

    System.out.println("getBit(123, 2) = " + getBit(num, 2));
    System.out.println("setBit(123, 2) = " + setBit(num, 2));
    System.out.println("clearBit(123, 2) = " + clearBit(num, 3));
    System.out.println("clearBitsIthrough0(123, 2) = " + clearBitsIthrough0(num, 3));
  }
}
