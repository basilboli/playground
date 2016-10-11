package graph;

import java.util.LinkedList;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 19/05/15
 */


public class DiGraph {

  boolean hasPathBetween(Node start, Node end) {

    LinkedList<Node> q = new LinkedList<>();
    q.add(start);

    while (!q.isEmpty()) {
      Node n = q.poll();
      for (Node i : n.getAdjacent()) {
        if (i.getState() != (State.Visited)) {
          n.setState(State.Visited);
          if (i.equals(end))
            return true;
          else {
            n.setState(State.Visiting);
            q.add(i);
          }

        }
      }
      n.setVisited();
    }

    return false;
  }

}
