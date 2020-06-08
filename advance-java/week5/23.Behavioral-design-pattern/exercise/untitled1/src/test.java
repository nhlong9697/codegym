public class test {
    public static void main(String[] args) {
        double a = 5.5;
        double b = 7.0;
        double c = 2.5;
        double d = --a + ++b + a - --c;
        System.out.println(d);
    }
}
interface Fish{}

class Perch implements Fish {}

class Walleye extends Perch{ }

class Bluegill { }