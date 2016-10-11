package graph;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 24/09/15
 */

class TreeNode {
  public String label;
  public int value;

  public TreeNode left;

  public TreeNode right;


  public TreeNode(String label) {
    this.label = label;
  }

  public TreeNode(int value) {
    this.value = value;
  }
}

public class Tree {

  TreeNode root;

  public TreeNode getRoot() {
    return root;
  }

  public void setRoot(TreeNode root) {
    this.root = root;
  }

  public int checkHeight(TreeNode node) {

    if (node == null)
      return 0;

    int lHeight = checkHeight(node.left);
    if (lHeight == -1)
      return -1; // Not balanced

    int rHeight = checkHeight(node.right);
    if (rHeight == -1)
      return -1; // Not balanced

    // check current node
    if (Math.abs(lHeight - rHeight) > 1)
      return -1;
    else
      return Math.max(lHeight, rHeight) + 1;
  }

  public boolean isBalanced(TreeNode node) {
    return (checkHeight(node) != -1);
  }

  boolean checkIsBST(TreeNode v) {
    return checkIsBST(v, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  boolean checkIsBST(TreeNode v, int min, int max) {
    // null case
    if (v == null) return true;

    // base case
    if (v.value <= min || v.value > max )
      return false;

    return checkIsBST(v.left, min, v.value)
            && checkIsBST(v.right, v.value, max);

  }

}
