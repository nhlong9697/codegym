import java.util.Scanner;

public class NPrime {
  public static boolean isPrime(int number) {
    if (number < 2) {
      return false;
    } else {
      int i = 2;
      while (i <= Math.sqrt(number)) {
        if (number % i == 0) {
          return false;
        }
        i++;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number of prime number to display: ");
    int n = input.nextInt();
    int count = 0;
    int potentialPrime = 2;
    while (count < n) {
      if (isPrime(potentialPrime)) {
        System.out.printf("%d ", potentialPrime);
        count += 1;
      }
      potentialPrime += 1;
    }
    input.close();
  }
}
