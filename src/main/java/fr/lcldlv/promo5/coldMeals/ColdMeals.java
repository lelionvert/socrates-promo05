package fr.lcldlv.promo5.coldMeals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ColdMeals {

    private final int checkInParticipantDates;

    ColdMeals() {
        checkInParticipantDates = 0;
    }

    public ColdMeals(CheckInDate checkInDate) {
        if (isCheckInAfterLimitTime(checkInDate)) {
            checkInParticipantDates = 1;
        } else {
            checkInParticipantDates = 0;
        }
    }

    public ColdMeals(List<CheckInDate> checkInDates) {
        List<CheckInDate> checkInsAfterLimit = checkInDates.stream()
                .filter(this::isCheckInAfterLimitTime)
                .collect(Collectors.toList());
        checkInParticipantDates = checkInsAfterLimit.size();
    }

    private boolean isCheckInAfterLimitTime(CheckInDate checkInDate) {
        return checkInDate.getHour() >= 21;
    }

    int count() {
        return checkInParticipantDates;
    }
}
