package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.DayOfWeek;

public class TaxiBooker {

    private final TrainArrivalsRepository trainArrivalsRepository;
    private final EmailSender emailSender;
    private final TaxiBookingDispatcher taxiBookingDispatcher;

    public static final String HEADER = "Jour;Heure;Nombre participants\n";

    public TaxiBooker(TrainArrivalsRepository trainArrivalsRepository, EmailSender emailSender, TaxiBookingDispatcher taxiBookingDispatcher) {
        this.trainArrivalsRepository = trainArrivalsRepository;
        this.emailSender = emailSender;
        this.taxiBookingDispatcher = taxiBookingDispatcher;
    }

    public void informTrainArrival(String participantName, String trainNumber, DayOfWeek day) {
        trainArrivalsRepository.add(new TrainArrival(participantName, trainNumber, day));
    }

    public void book() {

        emailSender.send(new Email("taxi@gmail.com", "", generateContent()));
    }

    private String generateContent() {
        StringBuilder contentBuilder = new StringBuilder(HEADER);

        for (TaxiBooking taxiBooking :
                taxiBookingDispatcher.generate()) {
            contentBuilder.append(String.format("%s;%d:%d;%d\n", taxiBooking.getDay(), taxiBooking.getHour(), taxiBooking.getMinute(), taxiBooking.getSeats()));
        }

        return contentBuilder.toString();
    }

}
