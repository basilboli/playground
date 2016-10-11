package linkedlist;

/**
 * $Id: $
 * <p/>
 * Author : Vasyl Vaskul (basilboli)
 * Created: 14/12/14
 */

class Node<T> {

  T data;
  Node<T> next;

  public Node(T value) {
    data = value;
  }
}

public class VVLinkedList<T> {

  Node<T> first;
  Node<T> last;

  int size = 0;

  public boolean add(T t) {
    linkLast(t);
    return true;
  }

  private void linkLast(T t) {
    final Node<T> l = last;
    final Node<T> newNode = new Node<>(t);
    last = newNode;
    if (l == null)
      first = newNode;
    else
      l.next = newNode;

    size++;
  }

  private void linkFirst(T t) {
    final Node<T> f = first;
    final Node<T> newNode = new Node<>(t);
    first = newNode;
    if (f == null)
      last = newNode;
    else
      newNode.next = f;

    size++;
  }

  public void push(T e) {
    addFirst(e);
  }

  private boolean addFirst(T e) {
    linkFirst(e);
    return true;
  }

  public Object[] toArray() {
    Object[] result = new Object[size];
    int i = 0;
    for (Node<T> x = first; x != null; x = x.next)
      result[i++] = x.data;
    return result;
  }

  @Override
  public String toString() {
    StringBuffer b = new StringBuffer();
    int i = 0;
    for (Node<T> x = first; x != null; x = x.next)
      b = b.append(" " + x.data + " ");

    return b.toString();
  }

  public static void main(String[] args) {

    VVLinkedList<String> list = new VVLinkedList<>();
    list.add("One");
    list.add("Two");
    list.add("Three");
    list.add("Four");
    System.out.println(list);
    list.push("Just added!");
    System.out.println(list);

  }
}
