import java.util.Scanner;
import java.util.Arrays;
public class AddElement {
  public static void main (String[] args) {

    int[] value = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    Scanner input = new Scanner(System.in);

    System.out.println("Enter position");
    int position = input.nextInt();
    System.out.println("Enter number");
    int number = input.nextInt();

    int[] result = new int[11];

    for (int i = 0; i < position; i++) {
      result[i] = value[i];
    }

    result[position] = number;

    for (int i = position + 1; i < 11; i++) {
      result[i] = value[i-1];
    }

    System.out.println("output is: " + Arrays.toString(result));
    input.close();
  }
}
