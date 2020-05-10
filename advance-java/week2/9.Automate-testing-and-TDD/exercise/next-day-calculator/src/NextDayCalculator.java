import java.time.LocalDate;

public class NextDayCalculator {
  public static LocalDate findNextDay(LocalDate date) {
    return date.plusDays(1);
  }
}
