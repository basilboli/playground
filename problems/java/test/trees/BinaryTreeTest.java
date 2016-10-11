package trees;

import org.junit.Test;

public class BinaryTreeTest {


  @Test
  public void testInOrderTraversal() throws Exception {

    BinaryTree bt = new BinaryTree();
    bt.insert(new int[]{40, 78, 25, 10, 32});

    System.out.println("In-order : ");
    bt.inOrder();
    System.out.println("Pre-order : ");
    bt.preOrder();
    System.out.println("Post-order : ");
    bt.postOrder();

  }

}