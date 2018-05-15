package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TaxiBookingDispatcher {
    private final TrainArrivalsRepository trainArrivalsRepository;

    private final Trains trains;

    public TaxiBookingDispatcher(TrainArrivalsRepository trainArrivalsRepository, Trains trains) {
        this.trainArrivalsRepository = trainArrivalsRepository;
        this.trains = trains;
    }

    public Collection<TaxiBooking> generate() {
        final Collection<TrainArrival> trainArrivals = trainArrivalsRepository.getTrainArrivals();

        final TrainArrival trainArrival = trainArrivals.iterator().next();

        final String trainNumber = trainArrival.getTrainNumber();


        final int arrivalsNumber = trainArrivals.size();

        final ArrayList<TaxiBooking> taxiBookings = new ArrayList<>();

        if(arrivalsNumber>4){
            final TaxiBooking taxiBooking = new TaxiBooking(trainArrival.getDay(),
                    trains.getArrivalTimeOf(trainNumber), 4);
            final TaxiBooking taxiBooking1 = new TaxiBooking(trainArrival.getDay(),
                    trains.getArrivalTimeOf(trainNumber), arrivalsNumber%4);
            taxiBookings.add(taxiBooking);
            taxiBookings.add(taxiBooking1);
            return taxiBookings;
        }

        final TaxiBooking taxiBooking = new TaxiBooking(trainArrival.getDay(),
                trains.getArrivalTimeOf(trainNumber), arrivalsNumber);


        return Collections.singleton(taxiBooking);
    }
}
