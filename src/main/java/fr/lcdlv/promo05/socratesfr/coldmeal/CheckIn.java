package fr.lcdlv.promo05.socratesfr.coldmeal;

import java.time.LocalTime;

public class CheckIn {

    private final LocalTime time;

    public CheckIn(int hours, int minutes) {
        this.time = LocalTime.of(hours, minutes);
    }

    public boolean isEqualsOrAfter(LocalTime time) {
        return this.time.equals(time) || this.time.isAfter(time);
    }
}

