package fr.lcdlv.promo05.socratesfr.taxireservation;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaxiBookerTest {
    private TaxiBooker taxiBooker;

    @Mock
    private EmailSender emailSender;

    @Mock
    private TrainArrivalsRepository trainArrivalsRepository;

    @Mock
    private TaxiBookingDispatcher taxiBookingDispatcher;

    @Before
    public void setUp() {
        taxiBooker = new TaxiBooker(trainArrivalsRepository, emailSender, taxiBookingDispatcher);
    }

    @Test
    public void informTrainArrival() {

        taxiBooker.informTrainArrival("participantName1", "8810", DayOfWeek.THURSDAY);
        verify(trainArrivalsRepository, times(1)).add(any(TrainArrival.class));
    }

    @Test
    public void sendEmail() {
        TaxiBooking taxiBooking = new TaxiBooking(LocalDateTime.of(2018, 10, 25, 17, 30), 4);

        given(taxiBookingDispatcher.generate())
                .willReturn(Lists.newArrayList(taxiBooking));

        taxiBooker.book();


        verify(emailSender).send(new Email("taxi@gmail.com", "", "Jour;Heure;Nombre participants\njeudi;17:30;4\n"));
    }
}