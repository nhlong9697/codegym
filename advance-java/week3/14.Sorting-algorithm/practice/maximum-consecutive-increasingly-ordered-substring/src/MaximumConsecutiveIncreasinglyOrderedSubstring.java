import java.util.LinkedList;
import java.util.Scanner;

public class MaximumConsecutiveIncreasinglyOrderedSubstring {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    LinkedList<Character> max = new LinkedList<>();
    LinkedList<Character> list = new LinkedList<>();
    System.out.print("Enter a string");
    String string = input.nextLine();

    for (int i = 0; i < string.length(); i++) {
      if (list.size() > 1 && string.charAt(i) <= list.getLast()) {
        list.clear();
      }
      list.addLast(string.charAt(i));

      if (max.size() < list.size()) {
        max.clear();
        max.addAll(list);
      }
    }

    for (Character character:max) {
      System.out.println(character);
    }
    System.out.println();
  }
}
