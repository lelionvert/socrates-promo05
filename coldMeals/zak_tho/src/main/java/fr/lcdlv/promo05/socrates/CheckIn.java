package fr.lcdlv.promo05.socrates;


import java.time.LocalTime;

class CheckIn {

    private final LocalTime time;

    public CheckIn(int hours, int minutes) {
        this.time = LocalTime.of(hours, minutes);
    }

    public boolean isEqualsOrAfter(LocalTime time) {
        return this.time.equals(time) || this.time.isAfter(time);
    }
}
