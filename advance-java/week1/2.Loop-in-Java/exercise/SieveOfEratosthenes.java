import java.util.Scanner;

public class SieveOfEratosthenes {
  public static void sieveOfEratosthenes(int number) {
    boolean prime[] = new boolean[number + 1];
    for (int i = 0; i < number; i++) {
      prime[i] = true;
    }
    for (int p = 2; p * p <= number; p++) {
      if (prime[p]) {
        for (int i = p * p; i <= number; i += p) {
          prime[i] = false;
        }
      }
    }
    for (int i = 2; i < number; i++) {
      if (prime[i]) {
        System.out.printf("%d ", i);
      }
    }
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number: ");
    int number = input.nextInt();
    sieveOfEratosthenes(number);
    input.close();
  }
}
