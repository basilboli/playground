package graph;

import java.util.Arrays;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 22/12/15
 */
public class CompareTwoTrees {

  /**
   * compare tree m with tree n
   * if differences return false
   */
  static void search(Node node) {
    if (node == null) return;
    visit(node);

    for (Node n : node.getAdjacent()) {
      if (!n.isVisited())
        search(n);
    }
  }

  static boolean compare(Node node, Node node1) {
    if (node == null) return false;
    if (node1 == null) return false;
//    System.out.println(String.format("Comparing %s with %s", node.getLabel(), node1.getLabel()));

    if (!node.getLabel().equals(node1.getLabel()))
      return false;

    visit(node);
    boolean result = true;
    for (Node n : node.getAdjacent()) {
      if (!n.isVisited()) {
        result = compare(n, node1.getByName(n.getLabel()));
        if (!result)
          break;
      }
    }
    return result;
  }

  static void visit(Node node) {
    node.setVisited();
//    System.out.println(node.getLabel() + " is visited");
  }

  static boolean testOk1 () {
     /*
                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g

                           vs.

                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g

     */

    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");

    Node a1 = new Node("a");
    Node b1 = new Node("b");
    Node c1 = new Node("c");
    Node d1 = new Node("d");
    Node e1 = new Node("e");
    Node f1 = new Node("f");
    Node g1 = new Node("g");

    a.setAdjacent(Arrays.asList(b, c));
    b.setAdjacent(Arrays.asList(d, e));
    c.setAdjacent(Arrays.asList(f, g));

    a1.setAdjacent(Arrays.asList(b1, c1));
    b1.setAdjacent(Arrays.asList(d1, e1));
    c1.setAdjacent(Arrays.asList(f1, g1));

    return compare(a,a1);
  }

  static boolean testOk2 () {
     /*
                           a
                         /   \
                        b     c

                           vs.

                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g

     */

    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");

    Node a1 = new Node("a");
    Node b1 = new Node("b");
    Node c1 = new Node("c");
    Node d1 = new Node("d");
    Node e1 = new Node("e");
    Node f1 = new Node("f");
    Node g1 = new Node("g");

    a.setAdjacent(Arrays.asList(b, c));

    a1.setAdjacent(Arrays.asList(b1, c1));
    b1.setAdjacent(Arrays.asList(d1, e1));
    c1.setAdjacent(Arrays.asList(f1, g1));

    return compare(a,a1);
  }

  static boolean testNotOk1 () {
     /*
                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g
                           vs.
                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g

     */

    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");

    Node a1 = new Node("a");
    Node b1 = new Node("b");
    Node c1 = new Node("c");
    Node d1 = new Node("d");
    Node e1 = new Node("e");
    Node f1 = new Node("f");

    a.setAdjacent(Arrays.asList(b, c));
    b.setAdjacent(Arrays.asList(d, e));
    c.setAdjacent(Arrays.asList(f, g));

    a1.setAdjacent(Arrays.asList(b1, c1));
    b1.setAdjacent(Arrays.asList(d1, e1));
    c1.setAdjacent(Arrays.asList(f1));

    return compare(a,a1);
  }

  static boolean testNotOk2 () {
     /*
                           a
                         / \ \
                        b  h  c
                      /  \   / \
                     d    e f  g

                          vs.

                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g


     */

    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node h = new Node("h");

    Node a1 = new Node("a");
    Node b1 = new Node("b");
    Node c1 = new Node("c");
    Node d1 = new Node("d");
    Node e1 = new Node("e");
    Node f1 = new Node("f");
    Node g1 = new Node("g");

    a.setAdjacent(Arrays.asList(b, c, h));
    b.setAdjacent(Arrays.asList(d, e));
    c.setAdjacent(Arrays.asList(f));

    a1.setAdjacent(Arrays.asList(b1, c1));
    b1.setAdjacent(Arrays.asList(d1, e1));
    c1.setAdjacent(Arrays.asList(f1, g1));

    return compare(a,a1);
  }


  static boolean testNotOk3 () {
     /*
                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g
                    /
                   h
     */

    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");
    Node h = new Node("h");

    Node a1 = new Node("a");
    Node b1 = new Node("b");
    Node c1 = new Node("c");
    Node d1 = new Node("d");
    Node e1 = new Node("e");
    Node f1 = new Node("f");
    Node g1 = new Node("g");

    a.setAdjacent(Arrays.asList(b, c));
    b.setAdjacent(Arrays.asList(d, e));
    c.setAdjacent(Arrays.asList(f));
    d.setAdjacent(Arrays.asList(h));

    a1.setAdjacent(Arrays.asList(b1, c1));
    b1.setAdjacent(Arrays.asList(d1, e1));
    c1.setAdjacent(Arrays.asList(f1, g1));

    return compare(a,a1);
  }


  public static void main(String[] args) {

    System.out.println(testOk1());
    System.out.println(testOk2());
    System.out.println(testNotOk1());
    System.out.println(testNotOk2());
    System.out.println(testNotOk3());
  }
}
