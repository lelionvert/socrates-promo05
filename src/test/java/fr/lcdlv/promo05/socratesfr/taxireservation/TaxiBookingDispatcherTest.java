package fr.lcdlv.promo05.socratesfr.taxireservation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TaxiBookingDispatcherTest {

    @Mock
    TrainArrivalsRepository trainArrivalsRepository;

    @Mock
    Trains trains;

    @Test
    public void generate() {
        given(trainArrivalsRepository.getTrainArrivals()).willReturn(Arrays.asList(
                new TrainArrival("ParticipantName1", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName2", "8810", DayOfWeek.THURSDAY)
        ));

        given(trains.getArrivalTimeOf("8810")).willReturn(LocalTime.of(17, 30));

        TaxiBookingDispatcher taxiBookingDispatcher = new TaxiBookingDispatcher(trainArrivalsRepository, trains);

        assertThat(taxiBookingDispatcher.generate())
                .containsExactly(new TaxiBooking(DayOfWeek.THURSDAY, LocalTime.of(17, 30), 2));
    }

    @Test
    public void more_than_4_arrivals_should_return_more_than_1_taxi_booking() {
        {
            given(trainArrivalsRepository.getTrainArrivals()).willReturn(Arrays.asList(
                    new TrainArrival("ParticipantName1", "8810", DayOfWeek.THURSDAY),
                    new TrainArrival("ParticipantName2", "8810", DayOfWeek.THURSDAY),
                    new TrainArrival("ParticipantName3", "8810", DayOfWeek.THURSDAY),
                    new TrainArrival("ParticipantName4", "8810", DayOfWeek.THURSDAY),
                    new TrainArrival("ParticipantName5", "8810", DayOfWeek.THURSDAY)
            ));

            given(trains.getArrivalTimeOf("8810")).willReturn(LocalTime.of(17, 30));

            TaxiBookingDispatcher taxiBookingDispatcher = new TaxiBookingDispatcher(trainArrivalsRepository, trains);

            assertThat(taxiBookingDispatcher.generate()).containsExactly(
                            new TaxiBooking(DayOfWeek.THURSDAY, LocalTime.of(17, 30), 4),
                            new TaxiBooking(DayOfWeek.THURSDAY, LocalTime.of(17, 30), 1)
                    );
        }
    }
}