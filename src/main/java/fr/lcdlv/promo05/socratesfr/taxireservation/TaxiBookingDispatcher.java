package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaxiBookingDispatcher {
    public static final int MAX_SEATS = 4;
    private final TrainArrivalsRepository trainArrivalsRepository;

    private final Trains trains;

    public TaxiBookingDispatcher(TrainArrivalsRepository trainArrivalsRepository, Trains trains) {
        this.trainArrivalsRepository = trainArrivalsRepository;
        this.trains = trains;
    }

    public Collection<TaxiBooking> generate() {
        final Collection<TrainArrival> trainArrivals = trainArrivalsRepository.getTrainArrivals();

        int remainingParticipantToSeat = trainArrivals.size();
        final ArrayList<TaxiBooking> taxiBookings = new ArrayList<>();

        final LocalTime arrivalTime = trainArrivals.stream()
                .map(TrainArrival::getTrainNumber)
                .map(trains::getArrivalTimeOf)
                .max(Comparator.comparing(LocalTime::toSecondOfDay))
                .get();

        final TrainArrival trainArrival = trainArrivals.iterator().next();

        while (remainingParticipantToSeat >= MAX_SEATS) {
            taxiBookings.add(new TaxiBooking(trainArrival.getDay(), arrivalTime, MAX_SEATS));
            remainingParticipantToSeat -= MAX_SEATS;
        }
        if (remainingParticipantToSeat != 0) {
            taxiBookings.add(new TaxiBooking(trainArrival.getDay(), arrivalTime, remainingParticipantToSeat));
        }
        return taxiBookings;
    }
}
