import java.util.Scanner;
public class QuadraticEquation {
  private double _a, _b, _c;
  public QuadraticEquation(double a, double b, double c) {
    this._a = a;
    this._b = b;
    this._c = c;
  }
  public double getA() {
    return this._a;
  }
  public double getB() {
    return this._b;
  }
  public double getC() {
    return this._c;
  }
  
  public void setA(double a) {
    this._a = a;
  }
  public void setB(double b) {
    this._b = b;
  }
  public void setC(double c) {
    this._c = c;
  }

  public double getDiscriminant() {
    return Math.pow(this._b,2) - 4*this._a*this._c;
  }
  
  public double getRoot1() {
    if (this.getDiscriminant() >= 0) {
      return (-this._b + Math.pow(this.getDiscriminant(), 0.5))/2*this._a;
    }
    else {
      return 0;
    }
  }
  
  public double getRoot2() {
    if (this.getDiscriminant() >= 0) {
      return (-this._b - Math.pow(this.getDiscriminant(), 0.5))/2*this._a;
    }
    else {
      return 0;
    }
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("a: ");
    double a = input.nextDouble();
    System.out.println("b: ");
    double b = input.nextDouble();
    System.out.println("c: ");
    double c = input.nextDouble();
    QuadraticEquation equation = new QuadraticEquation(a,b,c);
    if (equation.getDiscriminant() > 0) {
      System.out.println("Two roots: " + equation.getRoot1() + " " + equation.getRoot2());
    }
    else if (equation.getDiscriminant() == 0) {
      System.out.println("One root: " + equation.getRoot1());
    }
    else {
      System.out.println("No root");
    }
    input.close();
  }
}
