package Cyclinder;

public class TestCylinder {
  public static void main(String[] args) {
    Cylinder cylinder1 = new Cylinder();
    System.out.println(cylinder1);

    Cylinder cylinder2 = new Cylinder(3);
    System.out.println(cylinder2);

    Cylinder cylinder3 = new Cylinder("blue" , 4, 4);
    System.out.println(cylinder3);
  }
}
