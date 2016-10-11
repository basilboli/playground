package trees;

/**
 * Binary Tree implementation.
 *
 * <p/>
 * Note : implementing lookup, insert, checkBST methods
 * <p/>
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 17/05/15
 */

public class BinaryTree {
  Node root;

  public BinaryTree() {
  }


  public BinaryTree(Node root) {
    this.root = root;
  }

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  public boolean lookup(Node node, int data) {
    if (node == null)
      return false;

    if (node.data == data) {
      return true;
    } else if (data < node.data) {
      return (lookup(node.left, data));
    } else {
      return (lookup(node.right, data));
    }
  }

  public void insert(int[] data) {

    for (int i = 0; i < data.length; i++) {
      insert(data[i]);
    }
  }

  public void insert(int data) {
    root = insert(root, data);
  }

  private Node insert(Node node, int data) {
    if (node == null)
      return new Node(data);
    else {
      if (data <= node.data) {
        node.left = insert(node.left, data);
      } else {
        node.right = insert(node.right, data);
      }
    }
    return node;
  }

  public void build123a() {
    root = new Node(2);
    Node lChild = new Node(1);
    Node rChild = new Node(3);

    root.left = lChild;
    root.right = rChild;
  }

  /**
   * checking whether binary tree is binary "search" tree
   * time complexity is O(n)
   */
  public boolean checkBST() {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean checkBST(Node node, Integer min, Integer max) {
    if (node == null)
      return true;

    // check node itself
    if ((min != null && node.data <= min) || (max != null && node.data > max))
      return false;

    // check whether left and right subtrees are in range
    if (!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max))
      return false;

    return true;
  }

  public void inOrder() {
    inOrderRec(root);
    System.out.println("");
  }

  private void inOrderRec(Node node) {
    if (node == null) return;
    inOrderRec(node.left);
    System.out.print(node.data + ", ");
    inOrderRec(node.right);
  }

  public void preOrder() {
    preOrderRec(root);
    System.out.println("");
  }

  private void preOrderRec(Node node) {
    if (node == null) return;
    System.out.print(node.data + ", ");
    preOrderRec(node.left);
    preOrderRec(node.right);
  }

  public void postOrder() {
    postOrderRec(root);
    System.out.println("");
  }

  private void postOrderRec(Node node) {
    if (node == null) return;
    postOrderRec(node.left);
    postOrderRec(node.right);
    System.out.print(node.data + ", ");
  }

  private class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
      this.data = data;
    }
  }

}

