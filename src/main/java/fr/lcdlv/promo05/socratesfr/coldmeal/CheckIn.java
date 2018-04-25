package fr.lcdlv.promo05.socratesfr.coldmeal;

public class CheckIn {

    private final Integer checkInTime;

    private CheckIn(Integer time) {
        this.checkInTime = time;
    }

    public boolean isAfter(int time) {
        return this.checkInTime >= time;
    }

    static class CheckInFactory {
        public static final String CHECKIN_DATE_EMPTY_ERROR_MESSAGE = "Checkin time is empty !";
        public static final String CHECKIN_DATE_INVALID_ERROR_MESSAGE = "Checkin time is invalid !";

        public static CheckIn createFor(Integer time) {
            if (time == null) {
                throw new NullPointerException(CHECKIN_DATE_EMPTY_ERROR_MESSAGE);
            }
            if (time < 0 || time > 23) {
                throw new IllegalArgumentException(CHECKIN_DATE_INVALID_ERROR_MESSAGE);
            }
            return new CheckIn(time);
        }
    }
}

