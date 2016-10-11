package stack;

import java.util.Random;
import java.util.Stack;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 26/12/14
 */
public class SortStack extends Stack<Integer> {

  Stack<Integer> buffer = new Stack<>();

  public Stack<Integer> sort() {

    while (!this.isEmpty()) {
      int tmp = this.pop(); // Step 1

      while (!buffer.isEmpty() && buffer.peek() > tmp) { // Step 2
        this.push(buffer.pop());
      }
      buffer.push(tmp); // Step 3
    }

    return buffer;
  }

  public static void main(String[] args) {

    // sorting stack with biggest elements on top (ascending order)
    // using at most one additional stack to hold the items

    SortStack st = new SortStack();
    for (int i = 0; i < 100; i++) {
      st.add(new Random().nextInt(100));
    }
    System.out.println(st);
    System.out.println(st.sort());

  }
}
