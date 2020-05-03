import java.util.Scanner;

public class CharacterInString {
  public static int appearTime(String string, char targetCharacter) {
    int appearTime = 0;
    for (int i = 0; i < string.length(); i++) {
      if (string.charAt(i) == targetCharacter) {
        appearTime++;
      }
    }
    return appearTime;
  }
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.println("Enter the string to check");
    String string = input.nextLine();

    System.out.println("Enter the character to check");
    char targetCharacter = input.next().charAt(0);

    int appearTime = appearTime(string, targetCharacter);
    System.out.println("Number of times the character appear is: " + appearTime);
    input.close();
  }
}
