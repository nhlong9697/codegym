import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

  @Test
  void isFizzBuzz9() {
    int number = 9;
    String expected = "Fizz";
    String result = FizzBuzz.isFizzBuzz(number);
    assertEquals(expected,result);
  }

  @Test
  void isFizzBuzz10() {
    int number = 10;
    String expected = "Buzz";
    String result = FizzBuzz.isFizzBuzz(number);
    assertEquals(expected,result);
  }

  @Test
  void isFizzBuzz15() {
    int number = 15;
    String expected = "FizzBuzz";
    String result = FizzBuzz.isFizzBuzz(number);
    assertEquals(expected, result);
  }

  @Test
  void isFizzBuzz7() {
    int number = 7;
    String expected = "";
    String result = FizzBuzz.isFizzBuzz(number);
    assertEquals(expected, result);
  }

}