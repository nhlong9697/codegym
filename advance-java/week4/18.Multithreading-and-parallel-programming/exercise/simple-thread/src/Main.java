public class Main {
  public static void main(String[] args) {
    NumberGenerator oneToTen = new NumberGenerator(1,10);
    NumberGenerator elevenToTwenty = new NumberGenerator(11,20);

    Thread thread1 = new Thread(oneToTen);
    Thread thread2 = new Thread(elevenToTwenty);

    thread1.setPriority(Thread.MIN_PRIORITY);
    thread2.setPriority(Thread.MAX_PRIORITY);

    System.out.println("thread 1 priority is " + thread1.getPriority());
    System.out.println("thread 2 priority is " + thread2.getPriority());

    thread1.start();
    thread2.start();
  }
}
