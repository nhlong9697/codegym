package Point3D;
public class TestPoint3D {
  public static void main(String[] args) {
    Point3D point3D = new Point3D();
    point3D.setX(4);
    point3D.setY(5);
    point3D.setZ(3);
    System.out.println(point3D.toString());

    Point3D point3D1 = new Point3D(1,2,3);
    System.out.println(point3D1.toString());
    point3D1.setXYZ(6,7,8);
    System.out.println(point3D1.toString());
  }
}
