package Triangle;
import Shape.*;
public class Triangle extends Shape{
  private double _side1 = 1.0;
  private double _side2 = 1.0;
  private double _side3 = 1.0;

  public Triangle() {
  }

  public Triangle(double side1, double side2, double side3) {
    set3Side(side1,side2,side3);
  }

  public Triangle(String color, double side1, double side2, double side3) {
    super(color);
    set3Side(side1,side2,side3);
  }

  public double getSide3() {
    return _side3;
  }

  public void setSide3(double side3) {
    this._side3 = side3;
  }

  public double getSide2() {
    return _side2;
  }

  public void setSide2(double side2) {
    this._side2 = side2;
  }

  public double getSide1() {
    return _side1;
  }

  public void setSide1(double side1) {
    this._side1 = side1;
  }

  public void set3Side(double side1, double side2, double side3) {
    setSide1(side1);
    setSide2(side2);
    setSide3(side3);
  }

  public double getPerimeter() {
    return getSide1() + getSide2() + getSide3();
  }

  public double getArea() {
    return Math.sqrt(
            getPerimeter()/2 *
            (getPerimeter()/2 - getSide1()) *
            (getPerimeter()/2 - getSide2()) *
            (getPerimeter()/2 - getSide3())
    );
  }

  @Override
  public String toString() {
    return "The triangle derived from the class " + super.toString() +
            ", has Perimeter " + getPerimeter() +
            " and has Area " + getArea();
  }
}
