package srm156div2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiskSpaceTest {

  @Test
  public void testMindDrives() throws Exception {
    assertEquals(2, new DiskSpace().minDrives(new int[]{300,525,110}, new int[]{350,600,115}));
    assertEquals(1, new DiskSpace().minDrives(new int[]{1,200,200,199,200,200}, new int[]{1000,200,200,200,200,200}));
    assertEquals(5, new DiskSpace().minDrives(new int[]{750,800,850,900,950}, new int[]{800,850,900,950,1000}));
    assertEquals(49, new DiskSpace().minDrives(new int[]{49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49,49}, new int[]{50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50}));
    assertEquals(6, new DiskSpace().minDrives(new int[]{331,242,384,366,428,114,145,89,381,170,329,190,482,246,2,38,220,290,402,385}, new int[]{992,509,997,946,976,873,771,565,693,714,755,878,897,789,969,727,765,521,961,906}));
  }


}