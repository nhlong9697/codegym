package MovablePoint;

public class TestMovablePoint {
  public static void main(String[] args) {
    MovablePoint movablePoint = new MovablePoint(4,5,6,7);
    System.out.println(movablePoint.toString());
    movablePoint.move();
    System.out.println(movablePoint.toString());
  }
}
