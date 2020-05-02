import java.util.Scanner;
import java.util.Arrays;

public class MainDiagonalSum {
  public static int[][] newArray(int size) {
    Scanner input = new Scanner(System.in);
    int[][] array = new int[size][size];
    for (int row = 0; row < array.length; row++) {
      for (int col = 0; col < array[row].length; col++) {
        System.out.println("Enter array[" + row + "][" + col + "] value: ");
        array[row][col] = input.nextInt(); 
      }
    }
    return array;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter size: ");
    int size = input.nextInt();
    int[][] array = newArray(size);
    System.out.println("The entered array is: ");
    for (int row = 0; row < array.length; row++) {
      System.out.println(Arrays.toString(array[row]));
    }
    int mainDiagonalSum = mainDiagonalSum(array);
    System.out.println("The main diagonal sum is: " + mainDiagonalSum);
  }
  public static int mainDiagonalSum(int[][] array) {
    int mainDiagonalSum = 0;
    for (int i = 0; i < array.length; i++) {
      mainDiagonalSum += array[i][i];
    }
    return mainDiagonalSum;
  }
}
