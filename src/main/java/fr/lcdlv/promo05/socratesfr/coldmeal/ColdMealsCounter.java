package fr.lcdlv.promo05.socratesfr.coldmeal;

import java.util.List;

public class ColdMealsCounter {

    public static final int COLD_MEAL_TIME = 21;

    public static int countColdMeals(List<CheckIn> checkIns) {
        return Math.toIntExact(checkIns
            .stream()
            .filter(checkIn -> checkIn.isAfter(COLD_MEAL_TIME))
            .count());
    }
}
