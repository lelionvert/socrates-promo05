package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.DayOfWeek;

public class TaxiBooker {

    private final TrainArrivalsRepository trainArrivalsRepository;
    private final EmailSender emailSender;

    public TaxiBooker(TrainArrivalsRepository trainArrivalsRepository, EmailSender emailSender) {
        this.trainArrivalsRepository = trainArrivalsRepository;
        this.emailSender = emailSender;
    }

    public void informTrainArrival(String participantName, String trainNumber, DayOfWeek day) {
        trainArrivalsRepository.add(new TrainArrival());
    }

    public void book() {
        emailSender.send(new Email("taxi@gmail.com", "", ""));
    }
}
