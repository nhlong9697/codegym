import java.util.Scanner;

public class CurrencyConverter {
  public static void main(String[] args) {
    System.out.println("Enter amount to be converted: ");
    Scanner scanner = new Scanner(System.in);
    double usd = scanner.nextDouble();
    final double conversionRate = 23000;
    double vnd = usd * conversionRate;
    System.out.printf("The converted amount is %f", vnd);
  }
}
