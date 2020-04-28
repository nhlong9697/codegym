import java.util.Scanner;

public class DisplayShape {
  public static void rectangle() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 7; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }

  public static void squareTriangle() {
    // bottom-left
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
    System.out.println("");
    // top-left
    for (int i = 5; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }

  public static void isoscelesTriangle() {
    for (int i = 1; i <= 5; i++) {
      for (int j = i; j <= 5; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int choice = -1;
    while (choice != 0) {
      System.out.println("Menu");
      System.out.println("1. Draw the rectangle");
      System.out.println("2. Draw the square triangle");
      System.out.println("3. Draw the isosceles triangle");
      System.out.println("0. Exit");
      System.out.println("Enter your choice");
      choice = input.nextInt();
      switch (choice) {
        case 1:
          rectangle();
          break;
        case 2:
          squareTriangle();
          break;
        case 3:
          isoscelesTriangle();
          break;
        case 0:
          System.exit(0);
        default:
          System.out.println("Not valid choice!");
      }
    }
  }
}
