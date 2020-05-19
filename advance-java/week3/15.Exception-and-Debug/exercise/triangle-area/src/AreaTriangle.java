public class AreaTriangle {
  public static void main(String[] args) {
    try {
      Triangle triangle1 = new Triangle(1,2,3);
    } catch (IllegalTriangleException e) {
      System.out.println(e.getMessage());
      System.out.println("this is not a triangle");
    }
    try {
      Triangle triangle2 = new Triangle(3, 4, 5);
      System.out.println(triangle2.toString());
    } catch (IllegalTriangleException e) {
      System.out.println(e.getMessage());
      System.out.println("this is not a triangle");
    }
  }

  private static class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle() {
      this.a = this.b = this.c = 1.0;
    }

    public Triangle(double a, double b, double c) throws IllegalTriangleException {
      //if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || b + c <= a || c + a <= b) {
      //  throw new IllegalTriangleException(a, b, c);
      //}
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public double getA() {
      return a;
    }

    public void setA(double a) {
      this.a = a;
    }

    public double getB() {
      return b;
    }

    public void setB(double b) {
      this.b = b;
    }

    public double getC() {
      return c;
    }

    public void setC(double c) {
      this.c = c;
    }

    @Override
    public String toString() {
      return "Triangle size: " + " " + a + " " + b + " " + c;
    }
  }

  private static class IllegalTriangleException extends Exception {
    private double a;
    private double b;
    private double c;

    public IllegalTriangleException(double a, double b, double c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public double getA() {
      return a;
    }

    public double getB() {
      return b;
    }

    public double getC() {
      return c;
    }
  }
}
