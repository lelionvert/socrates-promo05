package fr.lcldlv.promo5.coldMeals;

import java.util.List;
import java.util.stream.Collectors;

public class ColdMealsCounter {

    private boolean isCheckInAfterLimitTime(CheckInTime checkInDate) {
        return checkInDate.getHour() >= 21;
    }

    int countColdMeals(List<CheckInTime> checkInDates) {
        return checkInDates.stream()
                .filter(this::isCheckInAfterLimitTime)
                .collect(Collectors.toList()).size();
    }
}
