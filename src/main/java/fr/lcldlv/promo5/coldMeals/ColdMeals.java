package fr.lcldlv.promo5.coldMeals;

public class ColdMeals {

    private final int checkInParticipantDates;

    ColdMeals() {
        checkInParticipantDates=0;
    }

    public ColdMeals(CheckInDate checkInDate) {
        if(checkInDate.getHour()>= 21){
            checkInParticipantDates=1;
        }
        else{
            checkInParticipantDates=0;
        }
    }

    int count() {
        return checkInParticipantDates;
    }
}
