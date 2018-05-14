package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.DayOfWeek;

public class TaxiBooker {

    final TrainArrivalsRepository trainArrivalsRepository;

    public TaxiBooker(TrainArrivalsRepository trainArrivalsRepository) {
        this.trainArrivalsRepository = trainArrivalsRepository;
    }

    public void informTrainArrival(String participantName, String trainNumber, DayOfWeek day) {
        trainArrivalsRepository.add(new TrainArrival());
    }

    public void book() {
        throw new UnsupportedOperationException();
    }
}
