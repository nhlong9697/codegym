public class MyList<E> {
  private int size = 0;
  private static final int DEFAULT_CAPACITY = 10;
  private Object elements[];

  public MyList() {
    this.elements = new Object[DEFAULT_CAPACITY];
  }

  public MyList(int capacity) {
    this.elements = new Object[capacity];
  }

  public void add(int index, E element) {
    checkIndexRangeForAdd(index);
    ensureCapacity(this.size);
    System.arraycopy(this.elements, index, this.elements, index + 1, this.size - index);
    this.elements[index] = element;
    this.size++;
  }

  private void ensureCapacity(int minCapacity) {
    if (minCapacity >= this.elements.length) {
      E[] newArrayList = (E[]) new Object[minCapacity * 2];
      System.arraycopy(this.elements,0, newArrayList,0,this.elements.length);
      this.elements = newArrayList;
    }
  }
  private void checkIndexRangeForAdd(int index) {
    if (index < 0 || index > this.size) {
      throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }
  }


  public E remove(int index) {
    checkIndexRange(index);
    E removedElement = (E) this.elements[index];
    if (this.size - index - 1 > 0)
      System.arraycopy(this.elements, index + 1, this.elements, index, this.size - index -1);
    this.elements[--this.size] = null;
    return removedElement;
  }
  private void checkIndexRange(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }
  }

  public int size() {
    return this.size;
  }

  @Override
  public E[] clone() {
    E[] copy= (E[]) new Object[this.elements.length];
    System.arraycopy(this.elements, 0, copy, 0, this.elements.length);
    return copy;
  }

  public boolean contains(E o) {
    for (int i = 0; i < this.size; i++) {
      if (elements[i].equals(o)) return true;
    }
    return false;
  }

  public int indexOf(E o) {
    for (int i = 0; i < this.size; i++) {
      if (elements[i].equals(o)) return i;
    }
    return -1;
  }

  public boolean add(E e) {
    ensureCapacity(this.size);
    this.elements[this.size++] = e;
    return true;
  }


  public E get(int i) {
    checkIndexRange(i);
    return (E) elements[i];
  }

  public void clear() {
    for (int i = 0; i < this.size; i++) {
      elements[i] = null;
    }
    this.size = 0;
  }

  @Override
  public String toString() {
    String result = "[";
    for (int i = 0; i < this.size - 1; i++) {
      result += this.elements[i] + ",";
    }
    result += this.elements[this.size - 1];
    result += "]";
    return result;
  }
}
