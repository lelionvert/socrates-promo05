package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.util.Collection;

interface TrainArrivalsRepository {

    Collection<TrainArrival> getTrainArrivals();

    void add(TrainArrival trainArrival);
}
