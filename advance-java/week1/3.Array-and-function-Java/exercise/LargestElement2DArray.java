import java.util.Scanner;
import java.util.Arrays;

public class LargestElement2DArray {
  public static int[][] inputArray() {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the height of the matrix");
    int height = input.nextInt();
    int width = input.nextInt();
    int[][] array = new int[height][width];
    //Input 2D array
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j ++) {
        System.out.println("Enter a[" + i + "][ " + j + "] value");
        array[i][j] = input.nextInt();
      }
    }  
    input.close();
    return array;
  }

  public static int findLargestValue(int[][] array) {
    int max = array[0][0];
    for (int row = 0; row < array.length; row++) {
      for (int col = 0; col < array[row].length; col++) {
        if (max < array[row][col]) {
          max = array[row][col];
        }
      }
    } 
    return max;
  } 
  public static void main(String[] args) {
    //find max value
    int[][] array = inputArray();
    System.out.println("The entered array is:" + Arrays.toString(array));
    int max = findLargestValue(array);
    System.out.println("The maxmimum value of the array is: " + max);
  }
}
