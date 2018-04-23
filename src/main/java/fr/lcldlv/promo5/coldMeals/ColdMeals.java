package fr.lcldlv.promo5.coldMeals;

public class ColdMeals {

    private final int checkInParticipantDates;

    ColdMeals() {
        checkInParticipantDates=0;
    }

    public ColdMeals(CheckInDate checkInDate) {
        if(isCheckInAfterLimitTime(checkInDate)){
            checkInParticipantDates=1;
        }
        else{
            checkInParticipantDates=0;
        }
    }

    private boolean isCheckInAfterLimitTime(CheckInDate checkInDate) {
        return checkInDate.getHour()>= 21;
    }

    int count() {
        return checkInParticipantDates;
    }
}
