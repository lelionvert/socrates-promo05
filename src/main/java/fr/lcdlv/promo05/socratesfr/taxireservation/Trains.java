package fr.lcdlv.promo05.socratesfr.taxireservation;

import java.time.LocalTime;

public interface Trains {
    LocalTime getArrivalTimeOf(String trainNumber);
}
