package MovablePoint;
import Point.*;
public class MovablePoint extends Point{
  private float _xSpeed;
  private float _ySpeed;

  public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
    super(x,y);
    _xSpeed = xSpeed;
    _ySpeed = ySpeed;
  }

  public MovablePoint(float xSpeed, float ySpeed) {
    _xSpeed = xSpeed;
    _ySpeed = ySpeed;
  }

  public MovablePoint() {
  }

  public float getXSpeed() {
    return _xSpeed;
  }
  public void setXSpeed(float xSpeed) {
    _xSpeed = xSpeed;
  }

  public float getYSpeed() {
    return _ySpeed;
  }
  public void setYSpeed(float ySpeed) {
    _ySpeed = ySpeed;
  }

  public void setSpeed(float xSpeed, float ySpeed) {
    setXSpeed(xSpeed);
    setYSpeed(ySpeed);
  }

  public float[] getSpeed() {
    float[] array = {getXSpeed(), getYSpeed()};
    return array;
  }

  public String toString() {
    return super.toString() + ", speed = (" + getSpeed()[0] + ", " + getSpeed()[1] + ")";
  }

  public MovablePoint move() {
    setX(getX() + getXSpeed());
    setY(getY() + getYSpeed());
    return this;
  }
}
