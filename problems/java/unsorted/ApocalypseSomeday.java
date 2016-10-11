/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 12/12/14
 */
public class ApocalypseSomeday {
  public int getNth(int n) {
    for (int i = 665; ; i++) {
      if (Integer.toString(i).contains("666"))
        if (n-- == 1)
          return i;
    }
  }
}
