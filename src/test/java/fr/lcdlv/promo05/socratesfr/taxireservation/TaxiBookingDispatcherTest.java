package fr.lcdlv.promo05.socratesfr.taxireservation;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxiBookingDispatcherTest {

    @Test
    public void generate() {

        TaxiBookingDispatcher taxiBookingDispatcher = new TaxiBookingDispatcher();
        assertThat(taxiBookingDispatcher.generate())
                .containsExactly( new TaxiBooking(LocalDateTime.of(2018,10,25,17,30),2));
    }
}