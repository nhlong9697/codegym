public class MyListTest {
  public static void main(String[] args) {
    MyList<Integer> list = new MyList<Integer>(3);
    list.add(0,3);
    list.add(1,4);
    list.add(1,5);
    list.add(0,10);
    list.add(2, 7);
    System.out.println(list);
  }
}
