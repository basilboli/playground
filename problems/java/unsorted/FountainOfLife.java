/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 12/12/14
 */
public class FountainOfLife {
  public double elixirOfDeath(int elixir, int poison, int pool) {
    if (elixir >= poison)
      return -1;
    double e = elixir, x = poison, p = pool;
    return p / (x - e);
  }
}
