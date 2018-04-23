package fr.lcdlv.promo05.socrates;


import java.time.LocalTime;

public class CheckinDate {

    private final LocalTime time;

    public CheckinDate(LocalTime time) {
        this.time = time;
    }

    public boolean isAfter9PM() {
        return time.equals(LocalTime.of(21, 00));
    }
}
