import java.util.Map;
import java.util.TreeMap;

public class TreeMapImplementation {
  public static void main(String[] args) {
    TreeMap<Character, Integer> treeMap = new TreeMap<>();
    StringBuilder inputString = new StringBuilder("This is a string");
    for (int i = 0; i < inputString.length(); i++) {
      Integer appearTime = treeMap.get(Character.toUpperCase(inputString.charAt(i)));
      if (appearTime == null) {
        treeMap.put(Character.toUpperCase(inputString.charAt(i)),1);
      }
      else {
        treeMap.put(Character.toUpperCase(inputString.charAt(i)), ++appearTime);
      }
    }
    for (Map.Entry m:treeMap.entrySet())
      System.out.println("Frequency of " + m.getKey() + " is " + m.getValue());
  }
}
