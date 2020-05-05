package com.codegym;

public class TestCircle {
  public static void main(String[] args) {
    Circle circle1 = new Circle();
    System.out.println(circle1.getArea());
    System.out.println(circle1.getRadius());

    Circle circle2 = new Circle(5);
    System.out.println(circle2.getArea());
    System.out.println(circle2.getRadius());
  }
}
