import javax.print.DocFlavor;
import java.util.Stack;

public class ConvertToBinary {
  public static void main(String[] args) {
    int number = 111;
    Stack<Integer> stackOfModulo = new Stack<>();
    StringBuilder binaryString = new StringBuilder("");
    while(number != 0) {
      stackOfModulo.push(number % 2);
      number /= 2;
    }
    while(!stackOfModulo.isEmpty()) {
      binaryString.append(stackOfModulo.pop());
    }
    System.out.println(binaryString);
  }
}