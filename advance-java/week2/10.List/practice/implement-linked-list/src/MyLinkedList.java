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
    checkAppendableElementIndex(index);
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
    if (this.head == null) {
      this.head = new Node(e);
    }
    else {
      while(temp.next != null) {
        temp = temp.next;
      }
      temp.next = new Node(e);
    }
    this.numNodes++;
  }

  public E remove(int index) {
    checkElementIndex(index);
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

  public boolean removeValue(Object e) {
    Node beforeDelete = this.head;
    if (this.head.getData().equals(e)) {
      this.head = this.head.next;
    }
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

  public Object clone() {
    Node temp = this.head;
    MyLinkedList<E> result = new MyLinkedList<>();
    while(temp != null) {
      E value = (E) temp.getData();
      result.addLast(value);
      temp = temp.next;
    }
    return result;
  }

  public boolean contains(E o) {
    Node temp = head;
    while(temp != null) {
      E value = (E) temp.getData();
      if(value.equals(o)) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  public int indexOf(E o) {
    Node temp = head;
    int index = 0;
    while(temp != null) {
      E value = (E) temp.getData();
      if (value.equals(o)) {
        return index;
      }
      index++;
      temp = temp.next;
    }
    return -1;
  }

  public E get(int index) {
    checkElementIndex(index);
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

  private boolean isElementIndex(int index) {
    return index >=0 && index < this.size();
  }
  private boolean isAppendableElementIndex(int index) {
    return index >=0 && index <= this.size();
  }
  private void checkElementIndex(int index) {
    if (!this.isElementIndex(index)) {
      throw new IndexOutOfBoundsException("index " + index + " out of bound");
    }
  }
  private void checkAppendableElementIndex(int index) {
    if (!this.isAppendableElementIndex(index)) {
      throw new IndexOutOfBoundsException("index " + index + " out of bound");
    }
  }
}
