public class Main {
  public static void main(String[] args) {
    MathCalculatorProxy proxy = new MathCalculatorProxy();
    double result = proxy.add(1,2);
    System.out.println(result);
    result = proxy.add(2,Double.MAX_VALUE);
    System.out.println(result);
  }
}
