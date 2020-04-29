class Employee {
  private int Id;
  private String name;
  private int age;
  private static int nextId = 1;

  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
    this.Id = nextId++;
  }

  public void show() {
    System.out.println("Id=" + this.Id + " Name=" + this.name + " Age=" + this.age);
  }

  public void showNextId() {
    System.out.println("Next employee id will be=" + nextId);
  }

  protected void finalize() {
    nextId--;
  }
}

/* // dont use garbage collector */
// class UseEmployee {
// public static void main(String[] args) {
// Employee A = new Employee("a", 1);
// Employee B = new Employee("b", 2);
// A.show();
// B.show();
// A.showNextId();
// B.showNextId();
// // block to use the intern
// // the block bellow will be pushed into stack frame
// {
// Employee C = new Employee("c", 3);
// C.show();
// C.showNextId();
// }
// // the block is finished and will be popped out and memory is deallocated
// // C.show(); will show error
// B.showNextId();
// }
/* } */
// dont use garbage collector
class UseEmployee {
  public static void main(String[] args) {
    Employee A = new Employee("a", 1);
    Employee B = new Employee("b", 2);
    A.show();
    B.show();
    A.showNextId();
    B.showNextId();
    // block to use the intern
    // the block bellow will be pushed into stack frame
    {
      Employee C = new Employee("c", 3);
      C.show();
      C.showNextId();
      C = null;
      System.gc();
      System.runFinalization();
    }
    // the block is finished and will be popped out and memory is deallocated
    // C.show(); will show error
    B.showNextId();
  }
}
