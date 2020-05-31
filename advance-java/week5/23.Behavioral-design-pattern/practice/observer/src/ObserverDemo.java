import java.util.Scanner;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject sub = new Subject();

        new BinObserver(sub);
        new OctObserver(sub);
        new BinObserver(sub);
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("\nEnter a number: ");
            sub.setState(input.nextInt());
        }
    }
}
