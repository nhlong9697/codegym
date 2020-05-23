public class Main {
  public static void main(String[] args) throws InterruptedException {
    OddThread oddThread = new OddThread();
    EvenThread evenThread = new EvenThread();

    oddThread.start();
    oddThread.join();
    evenThread.start();
  }
}
