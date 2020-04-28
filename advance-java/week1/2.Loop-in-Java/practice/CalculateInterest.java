import java.util.Scanner;

public class CalculateInterest {
  public static void main(String[] args) {
    double money = 1.0;
    int month = 1;
    double interest_rate = 1.0;
    Scanner input = new Scanner(System.in);

    System.out.println("Enter your investment: ");
    money = input.nextDouble();
    System.out.println("Enter number of month: ");
    month = input.nextInt();
    System.out.println("Enter annual interest rate in percentage: ");
    interest_rate = input.nextDouble();

    double total_interest = 0;

    for (int i = 0; i < month; i++) {
      total_interest = money * (interest_rate / 100) / 12 * 3;
    }

    System.out.println("Total of interest: " + total_interest);
    input.close();
  }
}
