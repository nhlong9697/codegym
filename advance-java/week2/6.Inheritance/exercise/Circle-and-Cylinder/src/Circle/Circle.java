package Circle;
public class Circle {
  private String _color;
  private double _radius;

  public Circle() {
  }

  public Circle(String color, double radius) {
    this._color = color;
    this._radius = radius;
  }

  public String getColor() {
    return this._color;
  }
  public void setColor(String color) {
    this._color = color;
  }

  public double getRadius() {
    return this._radius;
  }
  public void setRadius(double radius) {
    this._radius = radius;
  }

  public double getArea() {
    return this._radius * this._radius * Math.PI;
  }

  @Override
  public String toString() {
    return "The circle is " + getColor() + " and has a radius of " + getRadius() + " and area of " + getArea();
  }
}
