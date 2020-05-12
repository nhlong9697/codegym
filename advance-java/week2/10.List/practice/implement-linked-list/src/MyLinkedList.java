public class MyLinkedList<E>{
  private Node head;
  private int numNodes;
  private class Node {
    private Node next;
    private Object data;

    public Node(Object data) {this.data = data;}
    public Object getData() {
      return this.data;
    }
  }
  public MyLinkedList() {
  }

  public void add(int index, E element) {
    Node beforeInsert = this.head;
    for(int i = 0; i < index - 1; i++) {
      beforeInsert = beforeInsert.next;
    }
    Node temp = beforeInsert.next;
    beforeInsert.next = new Node(element);
    beforeInsert.next.next = temp;
    this.numNodes++;
  }

  public void addFirst(E e) {
    Node temp = this.head;
    this.head = new Node(e);
    this.head.next = temp;
    this.numNodes++;
  }

  public void addLast(E e) {
    Node temp = this.head;
    while(temp.next != null) {
      temp = temp.next;
    }
    temp.next = new Node(e);
    this.numNodes++;
  }

  public E remove(int index) {
    Node beforeDelete = this.head;
    for(int i = 0; i < index - 1; i++) {
      beforeDelete = beforeDelete.next;
    }
    E result = (E) beforeDelete.next.getData();
    //Node next = beforeDelete.next.next;
    //beforeDelete.next = next;
    beforeDelete.next = beforeDelete.next.next;
    this.numNodes--;
    return result;
  }

  public boolean remove(Object e) {
    Node beforeDelete = this.head;
    while(beforeDelete.next != null) {
      if (beforeDelete.next.getData().equals(e)) {
        beforeDelete.next = beforeDelete.next.next;
        this.numNodes--;
        return true;
      }
      beforeDelete = beforeDelete.next;
    }
    return false;
  }

  public int size() {
    return this.numNodes;
  }

  public E clone() {
    E result = (E) head.getData();
    return result;
  }

  public boolean contains(E o) {
    Node temp = head;
    while(temp.next != null) {
      if(temp.getData().equals(o)) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  public int indexOf(E o) {
    Node temp = head;
    int index = 0;
    while(temp.next != null) {
      if (temp.getData().equals(o)) {
        return index;
      }
      index++;
      temp = temp.next;
    }
    return -1;
  }

  public E get(int index) {
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    E result = (E) temp.getData();
    return result;
  }

  public E getFirst() {
    E result = (E) head.getData();
    return result;
  }

  public E getLast() {
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    E result = (E) temp.getData();
    return result;
  }

  public void clear() {
    this.head = null;
  }

  public void printList() {
    Node node = head;
    while(node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
  }
}
