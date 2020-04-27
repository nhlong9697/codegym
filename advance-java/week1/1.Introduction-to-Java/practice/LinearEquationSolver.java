import java.util.Scanner;

public class LinearEquationSolver {
  public static void main (String[] args) {
    System.out.println("Linear Equation Solver");
    System.out.println("Given a equation as 'a * x + b = 0', please enter constant");

    Scanner scanner = new Scanner(System.in);

    System.out.print("a: ");
    double a = scanner.nextDouble();
    System.out.print("b: ");
    double b = scanner.nextDouble();

    if (a != 0) {
      double solution = -b / a;
      System.out.println("The solution is: " + solution);
    }
    else {
      if (b == 0) {
        System.out.println("There are multiple solution");
      }
      else {
        System.out.println("No solution");
      }
    }
  }
}
