public class Main {
  public static final int DISTANCE = 100;
  public static final int STEP = 2;

  public static void main(String[] args) {
    Thread thread1 = new Thread(new Car("A"));
    Thread thread2 = new Thread(new Car("B"));
    Thread thread3 = new Thread(new Car("C"));

    System.out.println("Distance: 100KM");
    thread1.start();
    thread2.start();
    thread3.start();
  }
}
