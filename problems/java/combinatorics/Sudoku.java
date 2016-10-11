package combinatorics;

/**
 * Understanding backtracking technique
 *
 * <p/>
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 10/02/16
 */

public class Sudoku {

  final static int DIMENSION = 9;                         // 9*9 board
  final static int NCELLS = DIMENSION * DIMENSION;        // 81 cells in a 9*9 problem
  final boolean finished = false;                         // found all solutions yet?


  class Point {
    int x, y; // x and y coordinates of point
  }

  class Board {

    int[][] m = new int[DIMENSION+1][DIMENSION+1];
    int freecount;                                // how many open squares remain?
    Point[] move = new Point[NCELLS+1];           //  how did we fill the squares?

    public Point[] getMove() {
      return move;
    }
  }

  public void constructCandidates(int a[], int k, Board board, int[] c, int ncandidates) {
    int x = 0, y = 0; // position for the next move
    int i; // counter
    boolean[] possible = new boolean[DIMENSION+1]; // what is possible for the square
    //nextSquare(x, y, board); // which square should we fill next?

    board.getMove()[k].x = x; // store our choice of next position
    board.getMove()[k].y = y;

    ncandidates = 0;

    if (x < 0 && y < 0)
      return; // error condition, no moves possible

    //possibleValues(x, y, board, possible);

    for (int j = 0; j < DIMENSION; j++) {
      if (possible[j]) {
        c[ncandidates] = j;
        ncandidates++;
      }
    }

  }

  void processSolution(int a[], int k, Board board) {
    //print(board);
    //finished = true;
  }


  public void makeMove(int[] a, int k, Board board) {
    //fillSquare(board.getMove()[k].x, board.getMove()[k].y, a[k], board);
  }

  public void unMakeMove(int[] a, int k, Board board) {
    //freeSquare(board.getMove()[k].x, board.getMove()[k].y, a[k], board);
  }


  private boolean isSolution(int a[], int k, Board board) {
    return board.freecount == 0;
  }


  void backtrack(int a[], int k, Board board) {
    int c[] = new int[DIMENSION]; // candidates for next position
    int ncandidates = 0; // next position candidate count
    int i;

    if (isSolution(a, k, board)) {
      processSolution(a, k, board);
    }
    else {
      k = k + 1;
      constructCandidates(a, k, board, c, ncandidates);
      for (i = 0; i < ncandidates; i++) {
        a[k] = c[i];
        makeMove(a, k, board);
        backtrack(a, k, board);
        unMakeMove(a, k, board);
        if (finished)
          return; // terminate early
      }
    }
  }

}
