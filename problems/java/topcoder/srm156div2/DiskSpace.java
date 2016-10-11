package srm156div2;

import java.util.*;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 09/02/15
 */
public class DiskSpace {

//  public int minDrives(int[] used, int[] total) {
//
//    for (int i = 0; i < used.length; i++) {
//      System.out.print(used[i] + " ");
//    }
//    System.out.println("\n");
//    for (int i = 0; i < used.length; i++) {
//      System.out.print(total[i] + " ");
//    }
//    System.out.println("\n");
//
//    List <Integer> possibleSolutions = new ArrayList<>();
////    Collections.sort(disks, new UsedSpaceComparator());
//
//    for (int k = 0; k < total.length; k++) {
//
//      System.out.println("Trying " + k + " as pivot element!");
//      List<Disk> disks = new ArrayList<Disk>(used.length);
//
//      // init
//      for (int m = 0; m < total.length; m++) {
//        disks.add(new Disk("disk" + (m + 1), used[m], total[m]));
//      }
//
//      for (int i = k; i < total.length; i++) {
//        for (int j = 0; j < total.length; j++) {
//          System.out.println("Trying " + i + " and " + j);
//          // if disk i!=j and diskj is not full or diskj is not empty
//          if (i != j && !disks.get(i).isEmpty() && !disks.get(j).isFull() && !disks.get(j).isEmpty()) {
//            System.out.println("Before calibration " + disks);
//            // move maximum possible from diski to diskj
//            // update diski
//            int transfer = disks.get(i).getUsed();
//            if (transfer <= disks.get(j).getFree()) {
//              System.out.println("Adding " + transfer + "MB from " + disks.get(i).getName() + " to " + disks.get(j).getName());
//              disks.get(j).add(transfer);
//              disks.get(i).remove(transfer);
//            } else {
//              int diff = disks.get(j).getFree();
//              System.out.println("Adding " + diff + "MB from " + disks.get(i).getName() + " to " + disks.get(j).getName());
//              disks.get(j).add(diff);
//              disks.get(i).remove(diff);
//            }
//            System.out.println("After calibration" + disks);
//            System.out.println("Number of disks containing data " + getNumberOfDisksContainingData(disks));
//            System.out.println("\n");
//          }
//        }
//
//      }
//
//      possibleSolutions.add(getNumberOfDisksContainingData(disks));
//    }
//
//    System.out.println("Found solutions " + possibleSolutions);
//    return Collections.min(possibleSolutions);
//  }

  public int minDrives(int[] used, int[] total) {

    for (int i = 0; i < used.length; i++) {
      System.out.print(used[i] + " ");
    }
    System.out.println("\n");

    for (int i = 0; i < used.length; i++) {
      System.out.print(total[i] + " ");
    }
    System.out.println("\n");

    int v = 0;
    for (int x : used) v += x;
    System.out.println("Total used :" + v);
    Arrays.sort(total);

    int ans = 0;
    for (int i = total.length - 1; i >= 0; i--) {
      if (v != 0) ans++;
      System.out.println("ans" + ans);
      System.out.println("v=" + v);
      System.out.println("v-" + Math.min(v, total[i]));
      v -= Math.min(v, total[i]);
      System.out.println("v=" + v);

    }
    return ans;
  }
}

class Disk {
  private String name;

  private Integer used;
  private Integer total;
  private Integer free;

  public Disk(String name, int used, int total) {
    this.name = name;
    this.total = total;
    this.used = used;
    refresh();
  }

  public boolean isFull() {
    return this.getTotal().equals(this.getUsed());
  }

  public boolean isEmpty() {
    return this.getUsed() == 0;
  }

  public void add(Integer more) {
    this.used += more;
    refresh();
  }

  public void remove(Integer less) {
    this.used -= less;
    refresh();
  }

  public void refresh() {
    this.free = total - used;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getUsed() {
    return used;
  }

  public void setUsed(Integer used) {
    this.used = used;
  }

  public Integer getFree() {
    return free;
  }

  public void setFree(Integer free) {
    this.free = free;
  }

  @Override
  public String toString() {
    return "" + used;
  }
}

class UsedSpaceComparator implements Comparator<Disk> {
  @Override
  public int compare(Disk o1, Disk o2) {
    return o1.getUsed().compareTo(o2.getUsed());
  }
}

class FreeSpaceComparator implements Comparator<Disk> {
  @Override
  public int compare(Disk o1, Disk o2) {
    return o1.getFree().compareTo(o2.getFree());
  }
}