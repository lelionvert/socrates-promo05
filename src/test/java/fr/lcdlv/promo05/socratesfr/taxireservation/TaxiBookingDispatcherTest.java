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
    public void should_book_1_taxi_with_2_seats_when_2_participants_arrive_in_same_train() {
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
    public void should_book_2_taxis_with_respectably_4_and_1_seat_when_5_participants_arrive_in_same_train() {
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

    @Test
    public void should_book_3_taxis_with_4_seats_when_12_participants_arrive_in_same_train() {
        given(trainArrivalsRepository.getTrainArrivals()).willReturn(Arrays.asList(
                new TrainArrival("ParticipantName1", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName2", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName3", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName4", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName5", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName6", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName7", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName8", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName9", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName10", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName11", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName12", "8810", DayOfWeek.THURSDAY)
        ));

        given(trains.getArrivalTimeOf("8810")).willReturn(LocalTime.of(17, 30));

        TaxiBookingDispatcher taxiBookingDispatcher = new TaxiBookingDispatcher(trainArrivalsRepository, trains);

        assertThat(taxiBookingDispatcher.generate()).containsExactly(
                new TaxiBooking(DayOfWeek.THURSDAY, LocalTime.of(17, 30), 4),
                new TaxiBooking(DayOfWeek.THURSDAY, LocalTime.of(17, 30), 4),
                new TaxiBooking(DayOfWeek.THURSDAY, LocalTime.of(17, 30), 4)
        );
    }

    @Test
    public void should_wait_participant_until_taxi_is_full() {
        given(trainArrivalsRepository.getTrainArrivals()).willReturn(Arrays.asList(
                new TrainArrival("ParticipantName1", "8810", DayOfWeek.THURSDAY),
                new TrainArrival("ParticipantName2", "8830", DayOfWeek.THURSDAY)
        ));

        given(trains.getArrivalTimeOf("8810")).willReturn(LocalTime.of(17, 30));
        given(trains.getArrivalTimeOf("8830")).willReturn(LocalTime.of(18, 00));

        TaxiBookingDispatcher taxiBookingDispatcher = new TaxiBookingDispatcher(trainArrivalsRepository, trains);

        assertThat(taxiBookingDispatcher.generate()).containsExactly(
                new TaxiBooking(DayOfWeek.THURSDAY, LocalTime.of(18, 00), 2)
        );
    }
}