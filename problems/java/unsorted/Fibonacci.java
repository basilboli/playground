package problems;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 27/08/15
 */
public class Fibonacci {

  static long[] fib = new long[20000];

  public static long fibonacci(long n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static long factorial(long n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    return n * factorial(n - 1);
  }

  public static long fibonacci_opt(int n) {
    if (n <= 0) return 0;
    if (n == 1) return 1;
    if (fib[n] != 0) return fib[n];
    fib[n] = fibonacci_opt(n - 1) + fibonacci_opt(n - 2);
    return fib[n];
  }

  public static long xygrid(long x, long y) {
    return factorial(x + y) / factorial(x) * factorial(y);
  }


  public static void main(String[] args) {

    long time1 = System.currentTimeMillis();
//    System.out.println(Problems.fibonacci_opt(5000));
    System.out.println(Fibonacci.xygrid(4, 5));

    long time2 = System.currentTimeMillis();
    System.out.println("Taken (ms) " + (time2 - time1));

  }
}
