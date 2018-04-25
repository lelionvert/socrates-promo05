package fr.lcdlv.promo05.socratesfr.coldmeal;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CheckInTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void return_true_if_checkin_at_COLD_MEAL_TIME() throws Exception {
        CheckIn checkIn = CheckIn.CheckInFactory.createFor(21);
        Assertions.assertThat(checkIn.isAfter(ColdMealsCounter.COLD_MEAL_TIME)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void raise_exception_if_checkin_invalid_time_24() throws Exception {
        Assertions.assertThat(CheckIn.CheckInFactory.createFor(24))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void raise_exception_if_checkin_invalid_time_negative() throws Exception {
        Assertions.assertThat(CheckIn.CheckInFactory.createFor(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void raise_exception_if_checkin_null() throws Exception {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Checkin time is empty !");
        CheckIn.CheckInFactory.createFor(null);
    }

    @Test
    public void raise_exception_if_checkin_null_bis() throws Exception {
        Assertions.assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(()-> CheckIn.CheckInFactory.createFor(null))
            .withMessage("Checkin time is empty !");
    }
}