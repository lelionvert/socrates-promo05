package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.DayOfWeek;

public class TrainArrival {
    private final String participantName;
    private final String trainNumber;
    private final DayOfWeek day;

    public TrainArrival(String participantName, String trainNumber, DayOfWeek day) {

        this.participantName = participantName;
        this.trainNumber = trainNumber;
        this.day = day;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public DayOfWeek getDay() {
        return this.day;
    }
}
