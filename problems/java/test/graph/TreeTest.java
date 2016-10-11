package graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeTest {

  @Test
  public void testCheckBalancedWhenBalanced() throws Exception {

         /*
                           a
                         /   \
                        b     c
                      /  \   / \
                     d    e f  g

     */

    TreeNode a = new TreeNode("a");
    TreeNode b = new TreeNode("b");
    TreeNode c = new TreeNode("c");
    TreeNode d = new TreeNode("d");
    TreeNode e = new TreeNode("e");
    TreeNode f = new TreeNode("f");
    TreeNode g = new TreeNode("g");

    a.left = b;
    a.right = c;

    b.left = d;
    b.right = e;

    c.left = f;
    c.right = g;

    Tree tree = new Tree();
    tree.setRoot(a);

    assertTrue(tree.isBalanced(tree.getRoot()));
  }

  @Test
  public void testCheckBalancedWhenNotBalanced() throws Exception {

         /*
                           a
                         /
                        b
                      /
                     c

     */

    TreeNode a = new TreeNode("a");
    TreeNode b = new TreeNode("b");
    TreeNode c = new TreeNode("c");

    a.left = b;
    b.left = c;

    Tree tree = new Tree();
    tree.setRoot(a);

    assertFalse(tree.isBalanced(tree.getRoot()));
  }

  @Test
  public void testCheckIsNotBST() throws Exception {

         /*
                           a
                         /
                        b
                      /
                     c

     */

    TreeNode a = new TreeNode(20);
    TreeNode b = new TreeNode(10);
    TreeNode c = new TreeNode(30);
    TreeNode d = new TreeNode(5);
    TreeNode e = new TreeNode(9);

    a.left = b;
    a.right = c;

    b.left = d;
    b.right = e;


    Tree tree = new Tree();
    tree.setRoot(a);

    assertFalse(tree.checkIsBST(tree.getRoot()));
  }

  @Test
  public void testCheckIsBST() throws Exception {


    TreeNode a = new TreeNode(20);
    TreeNode b = new TreeNode(10);
    TreeNode c = new TreeNode(30);
    TreeNode d = new TreeNode(5);
    TreeNode e = new TreeNode(15);

    a.left = b;
    a.right = c;

    b.left = d;
    b.right = e;


    Tree tree = new Tree();
    tree.setRoot(a);

    assertTrue(tree.checkIsBST(tree.getRoot()));
  }
}