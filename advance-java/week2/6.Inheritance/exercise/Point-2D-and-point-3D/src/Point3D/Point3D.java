package Point3D;
import Point2D.*;
public class Point3D extends Point2D{
  private float _z;
  public Point3D(float x, float y, float z) {
    super(x,y);
    this._z = z;
  }
  public Point3D() {
  }

  public float getZ() {
    return this._z;
  }

  public void setZ(float z) {
    this._z = z;
  }

  public void setXYZ(float x, float y, float z) {
    super.setXY(x,y);
    setZ(z);
  }

  public float[] getXYZ() {
    float[] array = {super.getX(), super.getY(), this._z};
    return array;
  }

  @Override
  public String toString() {
    return "(" + getXYZ()[0] + ", " + getXYZ()[1] + ", " + getXYZ()[2] + ")";
  }
}
