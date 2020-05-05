package Point2D;

public class TestPoint2D {
  public static void main(String[] args) {
    Point2D point2D = new Point2D();
    point2D.setX(1);
    point2D.setY(2);
    System.out.println(point2D.toString());
    System.out.println(point2D.getX() + point2D.getY());

    Point2D point2D1 = new Point2D(6,7);
    System.out.println(point2D1.toString());
    point2D1.setXY(8,9);
    System.out.println(point2D1.getX() + point2D1.getY());
  }
}
