public class MathCalculatorProxy implements Calculator{
  private MathCalculator mathCalculator;

  public MathCalculatorProxy() {
    this.mathCalculator = new MathCalculator();
  }

  @Override
  public double add(double first, double second) {
    if (first/2 + second/2 >= Double.MAX_VALUE/2) {
      throw new RuntimeException("Out of range");
    }
    else if (first/2 + second/2 <= Double.MIN_VALUE/2) {
      throw new RuntimeException("Out of range");
    }
    else {
      return mathCalculator.add(first,second);
    }
  }

  @Override
  public double sub(double first, double second) {
    if (first/2 - second/2 >= Double.MAX_VALUE/2) {
      throw new RuntimeException("out of range");
    }
    else if (first/2 - second/2 <= Double.MIN_VALUE/2) {
      throw new RuntimeException("out of range");
    }
    else {
      return mathCalculator.sub(first, second);
    }
  }

  @Override
  public double mul(double first, double second) {
    double result = mathCalculator.mul(first,second);
    if (first != 0 && result/first != second) {
      throw new RuntimeException("Out of range");
    }
    return result;
  }

  @Override
  public double div(double first, double second) {
    if (second == 0) {
      throw new RuntimeException("Can't devide by zero");
    }
    return mathCalculator.div(first,second);
  }
}
