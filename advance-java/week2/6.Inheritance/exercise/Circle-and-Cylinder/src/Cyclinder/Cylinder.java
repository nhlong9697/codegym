package Cyclinder;
import Circle.*;
public class Cylinder extends Circle {
  private double _height;

  public Cylinder() {
  }

  public Cylinder(double height) {
    this._height = height;
  }

  public Cylinder(String color, double radius, double height) {
    super(color,radius);
    this._height = height;
  }

  public double getHeight() {
    return this._height;
  }
  public void setHeight(double height) {
    this._height = height;
  }

  public double getVolumne() {
    return super.getArea()*this._height;
  }

  @Override
  public String toString() {
    return "A cylinder with height of " + getRadius() + " and volumne of " + getVolumne() +
            " and is a subclass of " + super.toString();
  }
}
