package fr.lcldlv.promo5.coldMeals;

class CheckInTime {

    private final int hour;

    CheckInTime(int hour) {
        this.hour = hour;
    }

    boolean isAfter(int time) {
        return this.hour >= time;
    }
}
