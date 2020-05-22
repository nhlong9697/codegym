public class TaskThreadDemo {
  public static void main(String[] args) {
    Runnable printA = new PrintChar('a',100);
    Runnable printB = new PrintChar('b', 100);
    Runnable print100 = new PrintNum(100);

    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);

    thread1.start();
    thread2.start();
    thread3.start();
  }
}

class PrintChar implements Runnable {
  private char charToPrint;
  private int times;

  public PrintChar(char charToPrint, int times) {
    this.charToPrint = charToPrint;
    this.times = times;
  }

  //override run of runnable interface to tell system what to do
  @Override
  public void run() {
    try {

      for (int i = 0; i < times; i++) {
        System.out.print(charToPrint);
      }
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}

class PrintNum implements Runnable {
  private int lastNum;

  public PrintNum(int lastNum) {
    this.lastNum = lastNum;
  }
  @Override
  public void run() {
    Thread thread4 = new Thread(new PrintChar('c',40));
    thread4.start();
    try {
      for (int i = 1; i <= lastNum; i++) {
        System.out.print(" " + i);
        //Thread.yield();
        if (i == 50) thread4.join();
      }
    } catch (InterruptedException ex) {
    }
  }
}
