package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Objects;

public class TaxiBooking {
    private final DayOfWeek day;
    private final LocalTime time;
    private final int seats;

    public TaxiBooking(DayOfWeek day, LocalTime time, int seats) {
        this.day = day;
        this.time = time;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public String getDay() {
        return day.getDisplayName(TextStyle.FULL, Locale.FRANCE);
    }

    public int getHour() {
        return time.getHour();
    }

    public int getMinute() {
        return time.getMinute();
    }

    @Override
    public String toString() {
        return "TaxiBooking{" +
                "day=" + day +
                ", time=" + time +
                ", seats=" + seats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxiBooking that = (TaxiBooking) o;
        return seats == that.seats &&
                day == that.day &&
                Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {

        return Objects.hash(day, time, seats);
    }
}
