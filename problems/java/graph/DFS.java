package graph;

import java.util.Arrays;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 19/05/15
 */
public class DFS {

  void search(Node node) {
    if (node == null) return;
    visit(node);

    for (Node n : node.getAdjacent()) {
      if (!n.isVisited())
        search(n);
    }
  }

  void visit(Node node) {
    node.setVisited();
    System.out.println(node.getLabel() + " is visited");
  }

  public static void main(String[] args) {
    /*
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

    a.setAdjacent(Arrays.asList(b, c));
    b.setAdjacent(Arrays.asList(d, e));
    c.setAdjacent(Arrays.asList(f, g));

    new DFS().search(a);

  }


}
