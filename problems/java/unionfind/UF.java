import java.io.IOException;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 21/02/15
 */
public class UF {

  int id[];
  int count;

  public UF(int N) {
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  // complexity C=2
  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  // complexity C=1
  public int find(int p) {
    return id[p];
  }

  // complexity N+3 < C < 2 + N + (N-1)
  public void union(int p, int q) {

    int pc = find(p);
    int qc = find(q);
    if (pc == qc) return;

    for (int i = 0; i < id.length; i++) {
      if (id[i] == pc)
        id[i] = qc;
    }
    count--;
  }

  public static void main(String[] args) throws IOException {
    int N = StdIn.readInt();
    UF uf = new UF(N);
    while (!StdIn.isEmpty()) {
      int p = StdIn.readInt();
      int q = StdIn.readInt();
      if (uf.connected(p, q)) continue;
      uf.union(p, q);
      System.out.println(p + " " + q);
    }
    System.out.println(uf.count + "components");
  }

}
