package fr.lcdlv.promo05.socrates;


import java.time.LocalTime;

public class CheckIn {

    private final LocalTime time;

    public CheckIn(LocalTime time) {
        this.time = time;
    }

    public boolean isEqualsOrAfter9PM() {
        final LocalTime ninePM = LocalTime.of (21, 00);
        return time.equals(ninePM) || time.isAfter(ninePM);
    }
}
