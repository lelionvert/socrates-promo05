package fr.lcldlv.promo5.coldMeals;

import java.util.List;
import java.util.stream.Collectors;

public class ColdMealsCounter {

    private boolean isCheckInAfterLimitTime(CheckInDate checkInDate) {
        return checkInDate.getHour() >= 21;
    }

    int count() {
        return 0;
    }
    int count(List<CheckInDate> checkInDates) {
        return checkInDates.stream()
                .filter(this::isCheckInAfterLimitTime)
                .collect(Collectors.toList()).size();
    }
}
