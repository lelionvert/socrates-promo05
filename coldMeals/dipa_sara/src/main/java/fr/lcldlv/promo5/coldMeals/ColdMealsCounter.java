package fr.lcldlv.promo5.coldMeals;

import java.util.List;
import java.util.stream.Collectors;

public class ColdMealsCounter {

    public static final int COLD_MEALS_TIME_LIMIT = 21;

    int countColdMeals(List<CheckInTime> checkInDates) {
        return checkInDates.stream()
                .filter((checkInDate) -> checkInDate.isAfter(COLD_MEALS_TIME_LIMIT))
                .collect(Collectors.toList()).size();
    }
}
