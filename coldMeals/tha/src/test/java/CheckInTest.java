import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CheckInTest {

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();

    @Test
    public void return_true_if_checkin_at_COLD_MEAL_TIME() {
        CheckIn checkIn = CheckIn.CheckInFactory.createFor(21);
        Assertions.assertThat(checkIn.isAfter(ColdMealsCounter.COLD_MEAL_TIME)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void raise_exception_if_checkin_invalid_time_24() {
        Assertions.assertThat(CheckIn.CheckInFactory.createFor(24))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void raise_exception_if_checkin_invalid_time_negative() {
        Assertions.assertThat(CheckIn.CheckInFactory.createFor(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void raise_exception_if_checkin_null() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Checkin time is empty !");
        CheckIn.CheckInFactory.createFor(null);
    }

    @Test
    public void raise_exception_if_checkin_null_bis() {
        Assertions.assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(()-> CheckIn.CheckInFactory.createFor(null))
            .withMessage("Checkin time is empty !");
    }
}