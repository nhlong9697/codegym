import java.util.Scanner;
import java.util.Arrays;

public class RemoveElement {
  public static int[] removeMethodHelper(int[] array, int deleteValue) {

    int count = 0;
    for (int number : array) {
      if (number == deleteValue) {
        count++;
      }
    }

    if (count == 0) {
      return array;
    }

    int[] deleteArray = new int[array.length - count];
    int index = 0;
    for (int number : array) {
      if (number != deleteValue) {
        deleteArray[index] = number;
        index++;
      }
    }
    return deleteArray;
  }

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Enter array length
    System.out.println("Enter array length");
    int arrayLength = input.nextInt();

    // Enter array
    int[] array = new int[arrayLength];
    if (arrayLength > 0) {
      System.out.println("Enter array");
    }
    for (int i = 0; i < arrayLength; i++) {
      int element = input.nextInt();
      array[i] = element;
    }

    // Enter delete value
    System.out.println("Enter delete value");
    int deleteValue = input.nextInt();

    // Return to screen
    int[] deleteArray = removeMethodHelper(array, deleteValue);
    System.out.println("output is: " + Arrays.toString(deleteArray));
    input.close();
  }
}
