import java.util.Scanner;

public class Month {
  public static void main(String[] args) {
    System.out.println("Enter month: ");
    Scanner scanner = new Scanner(System.in);
    int month = scanner.nextInt();
    String days;
    switch (month) {
      case 2:
        days = "28 or 29 days";
        break;
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        days = "31 days";
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        days = "30 days";
        break;
      default:
        days = "";
        break;
    }
    if (days != "") System.out.printf("The month '%d' has '%s' days!",month, days);
    else System.out.print("Invalid input");
  }
}
