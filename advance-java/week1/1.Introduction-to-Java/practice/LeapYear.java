import java.util.Scanner;

public class LeapYear {
  public static void main (String[] args) {
    System.out.println("Enter year to check");
    Scanner scanner = new Scanner(System.in);
    int year = scanner.nextInt();
    boolean isLeapYear = false;
    boolean isDivisibleBy4 = year % 4 == 0;
    if (isDivisibleBy4) {
      boolean isDivisibleBy100 = year % 100 == 0;
      if (isDivisibleBy100) {
        boolean isDivisibleBy400 = year % 400 == 0;
        if (isDivisibleBy400) {
          isLeapYear = true;
        }
      }
      else {
        isLeapYear = true;
      }
    }
    if (isLeapYear) System.out.printf("The year '%d' is a leap year", year);
    else System.out.printf("The year '%d' is not a leap year", year);
  }
}
