import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

  @Test
  void testFindNextDay01012018() {
    LocalDate date = LocalDate.parse("2018-01-01");
    LocalDate expected = LocalDate.parse("2018-01-02");
    LocalDate result = NextDayCalculator.findNextDay(date);

    assertEquals(expected, result);
  }

  @Test
  void testFindNextDay20180131() {
    LocalDate date = LocalDate.parse("2018-01-31");
    LocalDate expected = LocalDate.parse("2018-02-01");
    LocalDate result = NextDayCalculator.findNextDay(date);

    assertEquals(expected, result);
  }

  @Test
  void testFindNextDay20180430() {
    LocalDate date = LocalDate.parse("2018-04-30");
    LocalDate expected = LocalDate.parse("2018-05-01");
    LocalDate result = NextDayCalculator.findNextDay(date);

    assertEquals(expected, result);
  }

  @Test
  void testFindNextDay20180228() {
    LocalDate date = LocalDate.parse("2018-02-28");
    LocalDate expected = LocalDate.parse("2018-03-01");
    LocalDate result = NextDayCalculator.findNextDay(date);

    assertEquals(expected, result);
  }

  @Test
  void testFindNextDay20200229() {
    LocalDate date = LocalDate.parse("2020-02-29");
    LocalDate expected = LocalDate.parse("2020-03-01");
    LocalDate result = NextDayCalculator.findNextDay(date);

    assertEquals(expected, result);
  }

  @Test
  void testFindNextDay20181231() {
    LocalDate date = LocalDate.parse("2018-12-31");
    LocalDate expected = LocalDate.parse("2019-01-01");
    LocalDate result = NextDayCalculator.findNextDay(date);

    assertEquals(expected, result);
  }
}