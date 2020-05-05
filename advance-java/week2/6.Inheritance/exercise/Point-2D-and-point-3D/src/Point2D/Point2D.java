package Point2D;
public class Point2D {
  private float _x;
  private float _y;
  public Point2D() {
  }
  public Point2D(float x, float y) {
    this._x = x;
    this._y = y;
  }

  public float getX() {
    return this._x;
  }
  public void setX(float x) {
    this._x = x;
  }

  public float getY() {
    return this._y;
  }
  public void setY(float y) {
    this._y = y;
  }

  public void setXY(float x, float y) {
    this._x = x;
    this._y = y;
  }

  public float[] getXY() {
    float[] array = {this._x, this._y};
    return array;
  }

  @Override
  public String toString() {
    return "(" + getXY()[0] + ", " + getXY()[1] + ")";
  }
}
