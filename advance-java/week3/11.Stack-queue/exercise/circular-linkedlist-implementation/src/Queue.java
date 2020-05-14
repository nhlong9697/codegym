public class Queue {
  public class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }
  Node front;
  Node rear;

  public void enqueue(int value) {
    Node temp = new Node(value);
    if (this.front == null) {
      this.front = temp;
      this.rear = temp;
    }
    else {
      this.rear.next = temp;
      this.rear = this.rear.next;
      this.rear.next = this.front;
    }
  }
  public int dequeue() {
    if (this.front == null) {
      return Integer.MIN_VALUE;
    }
    int value;
    if (this.front == this.rear) {
      value = this.front.value;
      this.front = null;
      this.rear = null;
    }
    else {
      Node temp = this.front;
      value = temp.value;
      this.front = this.front.next;
      temp = null;
      this.rear.next = this.front;
    }
    return value;
  }
  public void displayQueue() {
    Node temp = this.front;
    if (this.front == null) {
      System.out.println("no element");
      return;
    }
    while(temp.next != this.front) {
      System.out.println(temp.value);
      temp = temp.next;
    }
    System.out.println(temp.value);
  }
}
