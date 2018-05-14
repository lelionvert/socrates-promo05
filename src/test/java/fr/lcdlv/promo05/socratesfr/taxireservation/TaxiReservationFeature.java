package fr.lcdlv.promo05.socratesfr.taxireservation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.DayOfWeek;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TaxiReservationFeature {

    @Mock
    private EmailSender emailSender;

    private TaxiBooker taxiBooker;
    private TrainArrivalsRepository trainArrivalsRepository;

    @Before
    public void setUp() {
        trainArrivalsRepository = new InMemoryTrainArrivalsRepository();
        taxiBooker = new TaxiBooker(trainArrivalsRepository, emailSender);
    }

    @Test
    public void send_mail_after_booking_taxi() {

        taxiBooker.informTrainArrival("participantName1", "8810", DayOfWeek.THURSDAY);

        taxiBooker.informTrainArrival("participantName2", "8830", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName3", "8830", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName4", "8830", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName5", "8830", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName6", "8830", DayOfWeek.THURSDAY);

        taxiBooker.informTrainArrival("participantName7", "8850", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName8", "8850", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName9", "8850", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName10", "8850", DayOfWeek.THURSDAY);

        taxiBooker.informTrainArrival("participantName11", "8870", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName12", "8870", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName13", "8870", DayOfWeek.THURSDAY);

        taxiBooker.informTrainArrival("participantName14", "57345", DayOfWeek.THURSDAY);
        taxiBooker.informTrainArrival("participantName15", "57345", DayOfWeek.THURSDAY);

        taxiBooker.informTrainArrival("participantName16", "3456", DayOfWeek.FRIDAY);
        taxiBooker.informTrainArrival("participantName17", "3456", DayOfWeek.FRIDAY);

        taxiBooker.informTrainArrival("participantName18", "7830", DayOfWeek.FRIDAY);

        taxiBooker.book();

        String content = "Jour;Heure;Nombre participants\n" +
                "Jeudi;17:30;4\n" +
                "Jeudi;18:00;4\n" +
                "Jeudi;19:30;4\n" +
                "Jeudi;19:30;3\n" +
                "Vendredi;10:20;3";
        String to = "taxi@gmail.com";
        String subject = "Reservation 5 taxis";

        verify(emailSender).send(new Email(to, subject, content));

    }
}
