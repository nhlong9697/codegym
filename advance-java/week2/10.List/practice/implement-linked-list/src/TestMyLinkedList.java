
public class TestMyLinkedList {
  public static void main(String[] args) {
    MyLinkedList<Integer> llist = new MyLinkedList();
    llist.addFirst(7);
    llist.addFirst(8);
    llist.addFirst(9);
    llist.addFirst(10);
    llist.remove(2);
    llist.printList();
  }
}
