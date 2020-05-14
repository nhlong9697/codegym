import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class IsPalindrome {
  public static void main(String[] args) {
    String palindromeString = "Able was I ere I saw Elba";
    String notPalindromeString = "this is not a palindrome string";
    System.out.println(isPalindromeString(palindromeString));
    System.out.println(isPalindromeString(notPalindromeString));
  }
  public static boolean isPalindromeString(String inputString) {
    Stack<Character> characterStack = new Stack<>();
    ArrayBlockingQueue<Character> characterQueue = new ArrayBlockingQueue<>(inputString.length());
    for (int i = 0; i < inputString.length(); i++) {
      characterStack.push(Character.toLowerCase(inputString.charAt(i)));
      characterQueue.add(Character.toLowerCase(inputString.charAt(i)));
    }
    while(characterQueue.size() != 0 && (!characterStack.isEmpty())) {
      if (!characterQueue.poll().equals(characterStack.pop())) {
        return false;
      }
    }
    return true;
  }
}
