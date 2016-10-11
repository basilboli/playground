package problems;


import java.util.*;

/**
 * Imagine a robot sitting on the upper left corner of an X by Y grid.
 * The robot can only move in two directions: right and down.
 * How many possible paths are there for the robot to go from (0,0) to (X,Y)?
 * FOLLOW UP
 * Imagine certain spots are "off limits,"
 * such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class XYGrid {

  // TODO implement
  public static boolean isFree (int x, int y ) {
    // TODO check if (x,y) is free
    return true;
  }

  // suppose

  // to get to (x,y) we come from (x, y-1) or (x-1, y)

  public static boolean getPath (int x, int y, ArrayList<Point> path) {
    Point p = new Point(x, y);

    if (x == 0 && y == 0 )
      return true; // we have found the path

    boolean success = false;

    // let's try left
    if (x >=1 & isFree(x -1 ,y)) {
      success = getPath(x-1,y, path);
    }

    // let's try up
    if (!success && y >=1 && isFree(x,y-1)) {
      success = getPath(x,y-1, path);
    }

    if (success)
      path.add(p); // Great, this is part of our path!

    return success;
  }

  public static boolean getPathFaster (int x, int y,
                                ArrayList<Point> path,
                                HashMap<Point, Boolean> cache) {
    Point p = new Point(x, y);

    if (cache.containsKey(p))
      return cache.get(p);

    if (x == 0 && y == 0 )
      return true; // we have found the path

    boolean success = false;

    // let's try left
    if (x >=1 & isFree(x-1 ,y)) {
      success = getPath(x-1,y, path);
    }

    // let's try up
    if (!success && y >=1 && isFree(x,y-1)) {
      success = getPath(x,y-1, path);
    }

    cache.put(p, success); // cache result

    if (success) {
      path.add(p); // Great, this is part of our path!
    }

    return success;
  }

  public static void main(String[] args) {
    ArrayList<Point> path = new ArrayList<>();
    HashMap<Point, Boolean> cache = new HashMap<>();
    System.out.println(getPathFaster(1000, 1000, path, cache));
    System.out.println(path);
//    System.out.println(getPathFaster(3, 4, path, cache));
  }
}


class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }
}
