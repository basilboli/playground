package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 23/09/15
 */
public class  Node {

  String label;
  State state = State.NotVisited;
  List<Node> adjacent = new ArrayList<>();


  public boolean isVisited() {
    return state == State.Visited;
  }

  public void setVisited() {
    this.state = State.Visited;
  }

  public Node(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }


  public List<Node> getAdjacent() {
    return adjacent;
  }

  public boolean contains(String label) {
    for (Node n : adjacent) {
      if (n.getLabel().equals(label))
        return true;
    }

    return false;
  }

  public Node getByName(String label) {
    for (Node n : adjacent) {
      if (n.getLabel().equals(label))
        return n;
    }

    return null;
  }

  public void setAdjacent(List<Node> adjacent) {
    this.adjacent = adjacent;
  }


  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
}


