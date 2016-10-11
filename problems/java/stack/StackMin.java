package stack;

import java.util.Stack;

/**
 * Implement stack operating pop(), push() and min() in O(1) time
 *
 * Trick : use one minimum for the element series thus saving space.
 * <p/>
 * Example :
 * <p/>
 * Sequence 100 21 33 1 21 5 55
 * gives two stacks :
 * <p/>
 * 55 5 21 1 33 21 100
 * <p/>
 * 1 21 100
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 23/12/14
 */
public class StackMin {

  Stack<Integer> elements = new Stack<>();
  Stack<Integer> minimums = new Stack<>();

  public Stack<Integer> getElements() {
    return elements;
  }

  public Stack<Integer> getMinimums() {
    return minimums;
  }

  void push(int element) {
    if (element <= min()) {
      minimums.push(element);
    }
    elements.push(element);
  }

  int pop() {
    int element = elements.pop();
    if (element == min()) {
      minimums.pop();
    }
    return element;
  }

  int min() {
    if (minimums.isEmpty())
      return Integer.MAX_VALUE;
    return minimums.peek();
  }

  boolean isEmpty () {
    return elements.isEmpty();
  }
}
