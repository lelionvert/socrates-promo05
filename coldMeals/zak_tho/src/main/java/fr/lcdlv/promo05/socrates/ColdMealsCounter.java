package fr.lcdlv.promo05.socrates;

import java.time.LocalTime;
import java.util.List;

class ColdMealsCounter {

  public static final LocalTime COLD_MEALS_TIME = LocalTime.of(21, 00);

  public static int countColdMeals(final List<CheckIn> checkIns) {
      return Math.toIntExact(
        checkIns
            .stream()
            .filter(checkIn -> checkIn.isEqualsOrAfter (COLD_MEALS_TIME))
            .count()
    );
  }
}