import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
  public static void main(String[] args) {
    ArrayExample arrayExample = new ArrayExample();
    Integer[] array = arrayExample.createRandom();

    Scanner input = new Scanner(System.in);
    System.out.println("\n enter random number");
    int x = input.nextInt();
    try {
      System.out.println("the number at index " + x + " is " + array[x]);
    } catch (ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
      System.out.println("\n");
      System.out.println(e.getMessage());
      System.out.println("\n");
      System.out.println(e.toString());
    }
  }
  public Integer[] createRandom() {
    Random rd = new Random();
    Integer[] array = new Integer[100];
    System.out.println("list of elements of list");
    for (int i = 0; i < array.length; i++) {
      array[i] = rd.nextInt();
      System.out.println(array[i] + " ");
    }
    return array;
  }
}
