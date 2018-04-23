package fr.lcdlv.promo05.socrates;


import java.time.LocalTime;

public class CheckIn {

    private final LocalTime time;
    private static final LocalTime NINE_PM = LocalTime.of(21, 00);

    public CheckIn(int hours,int minutes) {
        this.time = LocalTime.of (hours,minutes);
    }

    public boolean isTooLate() {
        return time.equals(NINE_PM) || time.isAfter(NINE_PM);
    }
}
