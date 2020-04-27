import java.util.Scanner;

public class ReadNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    String numberString;
    if (number == 0) {
      numberString = "zero";
    } else if (number < 10 && number > 0) {
      numberString = convertOnes(number);
    } else if (number < 20 && number >= 10) {
      numberString = convertTeen(number);
    } else if (number >= 20 && number < 100) {
      int tens = number / 10;
      int ones = number % 10;
      String tensString;
      String onesString;
    }
  }

  public static String convertTeen(int number) {
    String numberString = "";
    switch (number) {
      case 10:
        numberString = "ten";
        break;
      case 11:
        numberString = "eleven";
        break;
      case 12:
        numberString = "twelve";
        break;
      case 13:
        numberString = "thirteen";
        break;
      case 14:
        numberString = "fourteen";
        break;
      case 15:
        numberString = "fifteen";
        break;
      case 16:
        numberString = "sixteen";
        break;
      case 17:
        numberString = "seventeen";
        break;
      case 18:
        numberString = "eighteen";
        break;
      case 19:
        numberString = "nineteen";
        break;
    }
    return numberString;
  }

  public static String convertOnes(int number) {
    String numberString = "";
    switch (number) {
      case 1:
        numberString = "one";
        break;
      case 2:
        numberString = "two";
        break;
      case 3:
        numberString = "three";
        break;
      case 4:
        numberString = "four";
        break;
      case 5:
        numberString = "five";
        break;
      case 6:
        numberString = "six";
        break;
      case 7:
        numberString = "seven";
        break;
      case 8:
        numberString = "eight";
        break;
      case 9:
        numberString = "nine";
        break;
    }
    return numberString;
  }

  public static String convertLargerThanTwenty(int number) {
    return null;
  }
}
