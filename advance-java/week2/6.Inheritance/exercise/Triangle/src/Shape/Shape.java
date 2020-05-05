package Shape;
public class Shape {
  private String _color;

  public Shape() {
  }

  public Shape(String color) {
    _color = color;
  }

  public void setColor(String color) {
    _color = color;
  }
  public String getColor() {
    return _color;
  }

  @Override
  public String toString() {
    return "A shape with color of " +
            _color;
  }
}
