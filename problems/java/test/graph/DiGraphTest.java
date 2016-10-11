package graph;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiGraphTest {

  @Test
  public void testHasPathBetween() throws Exception {
    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node d = new Node("d");
    Node e = new Node("e");

    a.setAdjacent(Arrays.asList(b, c));
    b.setAdjacent(Arrays.asList(d, e));

    assertTrue(new DiGraph().hasPathBetween(a, c));
    assertFalse(new DiGraph().hasPathBetween(c, e));
  }
}