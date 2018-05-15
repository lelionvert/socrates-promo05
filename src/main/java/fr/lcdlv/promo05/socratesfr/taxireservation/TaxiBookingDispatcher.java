package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.LocalTime;
import java.util.*;

public class TaxiBookingDispatcher {
    public static final int MAX_SEATS = 4;
    private final TrainArrivalsRepository trainArrivalsRepository;

    private final Trains trains;

    public TaxiBookingDispatcher(TrainArrivalsRepository trainArrivalsRepository, Trains trains) {
        this.trainArrivalsRepository = trainArrivalsRepository;
        this.trains = trains;
    }
      /*  final LocalTime arrivalTime = trainArrivals.stream()
                .map(TrainArrival::getTrainNumber)
                .map(trains::getArrivalTimeOf)
                .max(Comparator.comparing(LocalTime::toSecondOfDay))
                .get();
*/

    public Collection<TaxiBooking> generate() {
        final Collection<TrainArrival> trainArrivals = getTrainArrivalsFromRepository();


        Map<LocalTime, Integer> arrivalTimesByNumberOfParticipant = getArrivalTimesByNumberOfParticipant(trainArrivals);

        return bookTaxisByParticipants(trainArrivals, arrivalTimesByNumberOfParticipant);
    }

    private Collection<TrainArrival> getTrainArrivalsFromRepository() {
        return trainArrivalsRepository.getTrainArrivals();
    }

    private Collection<TaxiBooking> bookTaxisByParticipants(Collection<TrainArrival> trainArrivals, Map<LocalTime, Integer> arrivalTimesByNumberOfParticipant) {
        final ArrayList<TaxiBooking> taxiBookings = new ArrayList<>();
        final TrainArrival firstTrainArrival = trainArrivals.iterator().next();

        Set set = arrivalTimesByNumberOfParticipant.entrySet();
        Iterator iterator = set.iterator();
        Integer remainingSeats =0;
        LocalTime arrivalTimeTo = null;
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
             arrivalTimeTo = (LocalTime) mentry.getKey();
             remainingSeats += (Integer) mentry.getValue();
            while (remainingSeats >= MAX_SEATS) {
                taxiBookings.add(new TaxiBooking(firstTrainArrival.getDay(), arrivalTimeTo, MAX_SEATS));
                remainingSeats -= MAX_SEATS;
            }

        }
        if (remainingSeats != 0) {
            taxiBookings.add(new TaxiBooking(firstTrainArrival.getDay(), arrivalTimeTo, remainingSeats));
        }


        return taxiBookings;
    }

    private Map<LocalTime, Integer> getArrivalTimesByNumberOfParticipant(Collection<TrainArrival> trainArrivals) {
        Map<LocalTime, Integer> arrivalTimesByNumberOfParticipant = new HashMap<>();
        for (TrainArrival trainArrival : trainArrivals
                ) {
            Integer numberOfParticipant = 1;
            LocalTime arrivalTime = trains.getArrivalTimeOf(trainArrival.getTrainNumber());
            if (arrivalTimesByNumberOfParticipant.containsKey(arrivalTime)) {

                numberOfParticipant = arrivalTimesByNumberOfParticipant.get(arrivalTime);
                numberOfParticipant++;

            }
            arrivalTimesByNumberOfParticipant.put(arrivalTime, numberOfParticipant);

        }
        return arrivalTimesByNumberOfParticipant;
    }

}
