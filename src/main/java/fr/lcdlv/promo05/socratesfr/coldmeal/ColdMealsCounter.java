package fr.lcdlv.promo05.socratesfr.coldmeal;

import java.time.LocalTime;
import java.util.List;

public class ColdMealsCounter {

    private static final LocalTime COLD_MEALS_TIME = LocalTime.of(21, 00);

    static int countColdMeals(final List<CheckIn> checkIns) {
        return Math.toIntExact(
            checkIns
                .stream()
                .filter(checkIn -> checkIn.isEqualsOrAfter (COLD_MEALS_TIME))
                .count()
        );
    }
}
