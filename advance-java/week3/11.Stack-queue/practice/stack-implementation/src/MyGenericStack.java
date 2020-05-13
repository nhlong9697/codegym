import java.util.LinkedList;
public class MyGenericStack<T> {
  private LinkedList<T> stack;

  public MyGenericStack() {
    stack = new LinkedList();
  }

  public void push(T element) {
    stack.addFirst(element);
    //stack.addLast(element);
  }

  public T pop() {
    if(!isEmpty()) {
      return null;
    }
    return stack.removeFirst();
    //return stack.removeLast();
  }

  public boolean isEmpty() {
    if (stack.size() == 0)
      return true;
    return false;
  }
}
