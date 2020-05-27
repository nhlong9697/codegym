public class ShapeFactory {
  public Shape getShape(ShapeType shapeType) {
    switch (shapeType) {
      case SQUARE:
        return new Square();
      case RECTANGLE:
        return new Rectangle();
      case CIRCLE:
        return new Circle();
      default:
        return null;
    }
  }
}
