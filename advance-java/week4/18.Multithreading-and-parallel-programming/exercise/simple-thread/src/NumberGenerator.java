public class NumberGenerator implements Runnable{
  private int firstNumber;
  private int secondNumber;

  public NumberGenerator(int firstNumber, int secondNumber) {
    this.firstNumber = firstNumber;
    this.secondNumber = secondNumber;
  }

  @Override
  public void run() {
    try {
      for (int i = firstNumber; i <= secondNumber; i++) {
        System.out.println(i + " " + this.hashCode());
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
