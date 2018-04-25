package fr.lcldlv.promo5.coldMeals;

import java.util.stream.Collectors;

class ColdMealsCounter {

    private static final int COLD_MEALS_TIME_LIMIT = 21;

    int countColdMeals(CheckIns checkIns) {
        return checkIns.getCheckIns().stream()
                .filter((checkIn) -> checkIn.isAfter(COLD_MEALS_TIME_LIMIT))
                .collect(Collectors.toList()).size();
    }
}
