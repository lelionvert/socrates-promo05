package fr.lcldlv.promo5.coldMeals;

public class CheckInTime {

    private final int hour;

    public CheckInTime(int hour) {

        this.hour = hour;
    }

    public boolean isAfter(int time) {
        return this.hour >= time;
    }
}
