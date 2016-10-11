package linkedlist;

/**
 * Given a circular linked list, implement an algorithm which returns node at the begin- ning of the loop
 *
 * input:  A -> B -> C -> D -> E -> C [the same C as earlier]
 * output: C
 *
 *
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 15/12/14
 */
public class CircularLinkedList {

  /**
   *
   * @param head
   * @return null if list is not circular
   */
  public static Node returnLoopStart(Node<String> head) {

    // creating two pointers, fist moving +1, second +2 steps

    Node n1 = head;
    Node n2 = head;

    // Find meeting point
    while (n2.next != null) {
      n1 = n1.next;
      n2 = n2.next.next;
      if (n1 == n2)
        break;
    }

    // Error check - there is no meeting point, and therefore no loop
    if (n2.next == null) {
      return null; }

    /* Move n1 to Head. Keep n2 at Meeting Point. Each are k steps /* from the Loop Start. If they move at the same pace, they must
     * meet at Loop Start. */
    n1 = head;
    while (n1 != n2) {
      n1 = n1.next;
      n2 = n2.next;
    }

    return n2;
  }

  public static void main(String[] args) {
    Node <String> A  = new Node<>("A");
    Node <String> B  = new Node<>("B");
    Node <String> C  = new Node<>("C");
    Node <String> D  = new Node<>("D");
    Node <String> E  = new Node<>("E");

    A.next = B;
    B.next = C;
    C.next = D;
    D.next = E;
    E.next = C;

    System.out.println(returnLoopStart(A).data);

  }
}
