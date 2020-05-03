import java.util.Scanner;

public class Fan {
  final int SLOW = 1;
  final int MEDIUM = 2;
  final int FAST = 3;
  private int _speed = SLOW;
  private boolean _on = false;
  private double _radius = 5;
  private String _color = "blue";

  public int getSpeed() {
    return this._speed;
  }
  public void setSpeed(int speed) {
    this._speed = speed;
  }
  public boolean getOn() {
    return this._on;
  }
  public void setOn(boolean on) {
    this._on = on;
  }
  public double getRadius() {
    return this._radius;
  }
  public void setRadius(double radius) {
    this._radius = radius;
  }
  public String getColor() {
    return this._color;
  }
  public void setColor(String color) {
    this._color = color;
  }
  public Fan() {
  }

  @Override
  public String toString() {
    if (this._on)
      return getInfo() + " fan is on";
    else 
      return getInfo() + " fan is off";
  }
  public String getInfo() {
    return "" + this._speed + " " + this._radius + " " + this._color; 
  }

  public static void main(String[] args) {
    Fan fan1 = new Fan();
    Fan fan2 = new Fan();
    fan1.setSpeed(fan1.FAST);
    fan1.setRadius(10);
    fan1.setColor("yellow");
    fan1.setOn(true);
    fan2.setSpeed(fan1.MEDIUM);
    fan2.setRadius(5);
    fan2.setColor("blue");
    fan2.setOn(false);
    System.out.println(fan1.toString());
    System.out.println(fan2.toString());
  }
}

