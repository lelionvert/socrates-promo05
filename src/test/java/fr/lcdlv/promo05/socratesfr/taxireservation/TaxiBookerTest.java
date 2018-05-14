package fr.lcdlv.promo05.socratesfr.taxireservation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.DayOfWeek;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaxiBookerTest {
    private TaxiBooker taxiBooker;

    @Mock
    private TrainArrivalsRepository trainArrivalsRepository;

    @Before
    public void setUp() {
        taxiBooker = new TaxiBooker(trainArrivalsRepository);
    }

    @Test
    public void informTrainArrival() {

        taxiBooker.informTrainArrival("participantName1", "8810", DayOfWeek.THURSDAY);
        verify(trainArrivalsRepository, times(1)).add(any(TrainArrival.class));
    }
}