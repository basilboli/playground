package stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StackMinTest {


  @Test
  public void test() throws Exception {
    StackMin stackMin = new StackMin();
    //  Sequence 100 21 33 1 21 5 55
    stackMin.push(100);
    stackMin.push(21);
    stackMin.push(33);
    stackMin.push(1);
    stackMin.push(21);
    stackMin.push(5);
    stackMin.push(55);


    assertEquals("[100, 21, 33, 1, 21, 5, 55]", stackMin.getElements().toString());
    assertEquals("[100, 21, 1]", stackMin.getMinimums().toString());

    assertEquals(1, stackMin.min());
    assertEquals(55, stackMin.pop());

    assertEquals(1, stackMin.min());
    assertEquals(5, stackMin.pop());

    assertEquals(1, stackMin.min());
    assertEquals(21, stackMin.pop());

    assertEquals(1, stackMin.min());
    assertEquals(1, stackMin.pop());

    assertEquals(21, stackMin.min());
    assertEquals(33, stackMin.pop());

    assertEquals(21, stackMin.min());
    assertEquals(21, stackMin.pop());

    assertEquals(100, stackMin.min());
    assertEquals(100, stackMin.pop());

    assertEquals(Integer.MAX_VALUE, stackMin.min());
    assertTrue(stackMin.isEmpty());

  }

}
