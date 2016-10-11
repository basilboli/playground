package stack;

import java.util.Stack;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 26/12/14
 */
public class Tower {
  private Stack<Integer> disks;
  private int index;

  public Tower(int index) {
    this.disks = new Stack<>();
    this.index = index;
  }

  public int getIndex() {
    return index;
  }

  public void add (int d) {
    if (!disks.isEmpty() && disks.peek() <= d)
      System.out.println("Error placing disk " + d);
    else {
      disks.push(d);
    }
  }

  public void moveTopTo (Tower t) {
    int top = this.disks.pop();
    t.add(top);
    System.out.println("Moving disk " + top + " from " + getIndex() + " to " + t.getIndex());
  }



  public void moveDisks (int n, Tower destination, Tower buffer) {
    if (n > 0) {

      // move n-1 to buffer using destination as a buffer
      moveDisks(n-1, buffer, destination);

      // move top element from origin to destination
      moveTopTo(destination);

      // move top n-1 disks from buffer to destination using origin as a buffer
      buffer.moveDisks(n-1, destination, this);
    }
  }

  @Override
  public String toString() {
    return "Tower{" +
            "disks=" + disks +
            ", index=" + index +
            '}';
  }

  public static void main(String[] args) {

    int n = 5;

    Tower[] towers = new Tower[3];
    for (int i = 0; i < 3; i++) {
      towers[i] = new Tower(i);
    }

    for (int i = n; i >0; i--) {
      towers[0].add(i);
    }

    // printing stacks
    System.out.println(towers[0]);
    System.out.println(towers[1]);
    System.out.println(towers[2]);

    towers[0].moveDisks(n, towers[2], towers[1]);

    // printing stacks
    System.out.println(towers[0]);
    System.out.println(towers[1]);
    System.out.println(towers[2]);

  }
}
