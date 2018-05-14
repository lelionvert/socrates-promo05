package fr.lcdlv.promo05.socratesfr.taxireservation;

import com.sun.deploy.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class TaxiBooking {
    private final LocalDateTime pickUp;
    private final int seats;

    public TaxiBooking(LocalDateTime pickUp, int seats) {
        this.pickUp = pickUp;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public String getDay() {
        return pickUp.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE);
    }

    public int getHour() {
        return pickUp.getHour();
    }

    public int getMinute() {
        return pickUp.getMinute();
    }


}
