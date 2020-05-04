package com.codegym;
public class Circle {
  private double _radius = 1.0;
  private String _color = "red";

  public Circle() {
  }

  public Circle(double radius) {
    this._radius = radius;
  }

  public double getRadius() {
    return this._radius;
  }

  public double getArea() {
    return this._radius * this._radius * Math.PI;
  }
}
