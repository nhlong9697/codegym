import java.util.Scanner;
import java.util.Arrays;

public class BindArray {
  public static void main(String[] args) {
    int[] array1 = new int[] {1,2,3,4,5};
    System.out.println("The first array is: " + Arrays.toString(array1));
    int[] array2 = new int[] {6,7,8,9,10};
    System.out.println("The second array is : " + Arrays.toString(array2));

    int[] array3 = new int[array1.length + array2.length];
    //add 1st array element
    for (int i = 0; i < array1.length; i++) {
      array3[i] = array1[i];  
    }
    //add 2nd array element
    for (int j = 0; j < array2.length; j++) {
      array3[array1.length + j] = array2[j];
    }

    //print out result;
    System.out.println("The combined array is: " + Arrays.toString(array3));
  }
}
