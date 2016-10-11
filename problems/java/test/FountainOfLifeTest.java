import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class FountainOfLifeTest {

  FountainOfLife fountainOfLife = new FountainOfLife();

  @Test
  public void testElixirOfDeath() throws Exception {
    assertEquals (2.0, fountainOfLife.elixirOfDeath(1, 2, 2));
    assertEquals (-1.0, fountainOfLife.elixirOfDeath(200, 100, 1));
    assertEquals (10000.0, fountainOfLife.elixirOfDeath(9999, 10000, 10000));
    assertEquals (13.666666666666666, fountainOfLife.elixirOfDeath(40, 43, 41));
    assertEquals (-1.0, fountainOfLife.elixirOfDeath(43, 42, 41));
    assertEquals (1.0001000100010001E-4, fountainOfLife.elixirOfDeath(1, 10000, 1));
  }
}