import java.util.Scanner;
import java.util.Arrays;

public class SumOfCol {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    //input array width & height
    System.out.println("Enter height of two dimension array: ");
    int height = input.nextInt();
    System.out.println("Enter width of two dimension array: ");
    int width = input.nextInt();

    //declare the array;
    int[][] array = newArray(height, width);

    System.out.println("The entered array is: ");
    for (int row = 0; row < array.length; row++) {
      System.out.println(Arrays.toString(array[row]));
    }

    //enter column
    System.out.println("Enter the column to calculate: ");
    int col = input.nextInt();

    //display result
    int sumOfCol = sumOfCol(array,col);
    System.out.println("Sum of " + col + " column is " + sumOfCol);

  }

  public static int[][] newArray(int height, int width) {
    Scanner input = new Scanner(System.in);
    int[][] array = new int[height][width];
    for (int row = 0; row < array.length; row++) {
      for (int col = 0; col < array[row].length; col++) {
        System.out.println("Enter array[" + row + "][" + col + "] value: ");
        array[row][col] = input.nextInt(); 
      }
    }
    return array;
  }
  public static int sumOfCol(int[][] array, int col) {
    int sumOfCol = 0;
    for (int row = 0; row < array.length; row++) {
      sumOfCol += array[row][col];
    }
    return sumOfCol;
  }
}
