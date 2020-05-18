import java.util.LinkedList;
import java.util.Scanner;

public class MaximumIncreasinglyOrderedSubsequence {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter a string: ");
    String string = input.nextLine();

    LinkedList<Character> max = new LinkedList<>();

    for (int i = 0; i < string.length(); i++) {
      LinkedList<Character> potentialList = new LinkedList<>();
      for (int j = i + 1; j < string.length(); j++) {
        if (string.charAt(j) > potentialList.getLast()) {
          potentialList.add(string.charAt(j));
        }
      }
      if (potentialList.size() > max.size()) {
        max.clear();
        max.addAll(potentialList);
      }
      potentialList.clear();
    }

    for (Character ch:max) {
      System.out.println(ch);
    }
  }
}
