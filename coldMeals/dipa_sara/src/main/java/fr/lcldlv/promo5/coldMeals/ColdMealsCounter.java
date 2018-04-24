package fr.lcldlv.promo5.coldMeals;

import java.util.List;
import java.util.stream.Collectors;

public class ColdMealsCounter {

    public static final int COLD_MEALS_TIME_LIMIT = 21;

    private boolean isCheckInAfterLimitTime(CheckInTime checkInDate) {
        return checkInDate.isAfter(COLD_MEALS_TIME_LIMIT);
    }

    int countColdMeals(List<CheckInTime> checkInDates) {
        return checkInDates.stream()
                .filter(this::isCheckInAfterLimitTime)
                .collect(Collectors.toList()).size();
    }
}
