package fr.lcdlv.promo05.socrates;


import java.time.LocalTime;

public class CheckIn {

    private final LocalTime time;
    private static final LocalTime NINE_PM = LocalTime.of(21, 00);

    public CheckIn(LocalTime time) {
        this.time = time;
    }

    public boolean isTooLate() {
        return time.equals(NINE_PM) || time.isAfter(NINE_PM);
    }
}
