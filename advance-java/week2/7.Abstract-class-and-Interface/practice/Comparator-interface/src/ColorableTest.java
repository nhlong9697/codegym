public class ColorableTest {
  public static void main(String[] args) {
    Shape[] shapes = new Shape[4];
    shapes[0] = new Circle(4, "green", true);
    shapes[1] = new Rectangle();
    shapes[2] = new Square(6);
    shapes[3] = new Shape("red", false);

    for (Shape shape : shapes) {
      if (shape instanceof Colorable) {
        Square square = (Square) shape;
        System.out.println(square.getArea());
        square.howToColor();
      }
    }
  }
}
