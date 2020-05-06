import java.util.Arrays;
import java.util.Comparator;
public class CircleComparatorTest {
  public static void main(String[] args) {
    Circle[] circles = new Circle[3];
    circles[0] = new Circle(3.6);
    circles[1] = new Circle();
    circles[2] = new Circle(3.5, "indigo", false);

    System.out.println("Pre-sorted:");
    for (Circle circle : circles) {
      System.out.println(circle);
    }

    Comparator circleComparator = new CircleComparator();
    Arrays.sort(circles, circleComparator);
    //Arrays.sort use an object that has the Comparable<T> interface
    //implements circleComparator.compareTo(some elements of circle);
    //implements a swap & sort method using the above method

    System.out.println("After-sorted:");
    for (Circle circle : circles) {
      System.out.println(circle);
    }
  }
}
