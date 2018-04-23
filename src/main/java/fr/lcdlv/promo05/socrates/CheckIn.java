package fr.lcdlv.promo05.socrates;


import java.time.LocalTime;

public class CheckIn {

    private final LocalTime time;

    public CheckIn(LocalTime time) {
        this.time = time;
    }

    public boolean isAfter9PM() {
        return time.equals(LocalTime.of(21, 00)) || time.isAfter(LocalTime.of(21, 00));
    }
}
