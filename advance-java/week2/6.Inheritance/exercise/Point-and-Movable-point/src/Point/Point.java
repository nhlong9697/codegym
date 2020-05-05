package Point;
public class Point {
  private float _x;
  private float _y;

  public Point(float x, float y) {
    _x = x;
    _y = y;
  }

  public Point() {
  }

  public float getX() {
    return _x;
  }
  public void setX(float x) {
    _x = x;
  }

  public float getY() {
    return _y;
  }
  public void setY(float y){
    _y = y;
  }

  public void setXY(float x, float y) {
    _x = x;
    _y = y;
  }

  public float[] getXY() {
    float[] array = {_x,_y};
    return array;
  }
  @Override
  public String toString() {
    return "(" + _x + ", " + _y + ")";
  }
}
