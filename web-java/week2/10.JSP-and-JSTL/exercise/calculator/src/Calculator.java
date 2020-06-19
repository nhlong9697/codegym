public class Calculator {
  public static double calculate(double firstOperand, double secondOperand, String operator) {
    switch (operator) {
      case "+":
        return firstOperand + secondOperand;
      case "-":
        return firstOperand - secondOperand;
      case "*":
        return firstOperand * secondOperand;
      case "/":
        if (secondOperand != 0) {
          return firstOperand / secondOperand;
        } else {
          throw new ArithmeticException("divide to zero");
        }
      default:
        throw new RuntimeException("Run time exception");
    }
  }
}
