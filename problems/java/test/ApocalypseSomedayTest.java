import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApocalypseSomedayTest {

  @Test
  public void testGetNth() throws Exception {
    ApocalypseSomeday apocalypseSomeday  = new ApocalypseSomeday();
    assertEquals(666, apocalypseSomeday.getNth(1));
    assertEquals(1666, apocalypseSomeday.getNth(2));
  }
}