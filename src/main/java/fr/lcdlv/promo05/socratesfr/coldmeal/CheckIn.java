package fr.lcdlv.promo05.socratesfr.coldmeal;

public class CheckIn {

    private final int hour;

    CheckIn(int hour) {
        this.hour = hour;
    }

    boolean isAfter(int time) {
        return this.hour >= time;
    }
}

