public class MyLinkedListQueue {
  private Node head;
  private Node tail;

  public MyLinkedListQueue() {
    this.head = null;
    this.tail = null;
  }

  public void enqueue (int key) {
    Node temp = new Node(key);
    if (this.tail == null) {
      this.head = this.tail = temp;
      return;
    }
    this.tail.next = temp;
    this.tail = temp;
    //this.tail = this.tail.next;
  }

  public Node dequeue() {
    if (this.head == null) {
      return null;
    }
    Node temp = this.head;
    this.head = this.head.next;
    //1 node only
    if (this.head == null) {
      this.tail = null;
    }
    return temp;
  }
}
