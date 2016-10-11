package graph;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 23/09/15
 */
public class BFS {

  Queue<Node> queue = new LinkedBlockingQueue<Node>();

  void search (Node node) {

    if (node == null) return;

    visit(node);

    queue.add(node);

    while (!queue.isEmpty()) {
      Node n = queue.poll();
      for (Node r : n.getAdjacent()) {
        if (!r.isVisited()) {
          visit(r);
          queue.add(r);
        }
      }
    }
  }

  void visit(Node node) {
    node.setVisited();
    System.out.println(node.getLabel() + " is visited");
  }

  public static void main(String[] args) {
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");

    a.setAdjacent(Arrays.asList(b, c));
    b.setAdjacent(Arrays.asList(d, e));

    new BFS().search(a);

  }
}
