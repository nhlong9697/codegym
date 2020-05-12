import java.util.LinkedList;

public class TestMyLinkedList {
  public static void main(String[] args) {
    MyLinkedList<Integer> llist = new MyLinkedList();
    llist.addFirst(1);
    llist.addLast(3);
    llist.add(1,2);
    llist.addLast(4);
    llist.addLast(5);
    llist.addLast(6);
    llist.printList();
    System.out.println("size");
    System.out.println(llist.size());
    System.out.println("get first");
    System.out.println(llist.getFirst());
    System.out.println("get last");
    System.out.println(llist.getLast());
    System.out.println("get value index 4");
    System.out.println(llist.get(4));
    //System.out.println("get value index 100");
    //System.out.println(llist.get(100));
    llist.printList();
    System.out.println("contain 6?");
    System.out.println(llist.contains(6));
    System.out.println("contain 7?");
    System.out.println(llist.contains(7));
    System.out.println("index of value 6");
    System.out.println(llist.indexOf(6));
    System.out.println("index of value 7");
    System.out.println(llist.indexOf(7));
    //System.out.println("remove index 100");
    //System.out.println(llist.remove(100));
    System.out.println("remove last index");
    System.out.println(llist.remove(llist.size()-1));
    llist.printList();
    System.out.println("remove 5");
    System.out.println(llist.removeValue(5));
    llist.printList();
    MyLinkedList<Integer> llist2 = (MyLinkedList<Integer>) llist.clone();
    llist2.printList();
    llist.clear();
    llist.printList();
  }
}
