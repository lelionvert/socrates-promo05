package fr.lcdlv.promo05.socratesfr.coldmeal;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInTest {
    public static final LocalTime TIME_TO_COMPARE = LocalTime.of (21, 00);

    @Test
    public void returns_false_if_check_in_is_before_time() {
        assertThat(
            new CheckIn(20,59).isEqualsOrAfter (TIME_TO_COMPARE)
        ).isEqualTo(
            false
        );
    }

    @Test
    public void returns_true_if_check_in_is_the_same_as_time() {
        assertThat(
            new CheckIn(21,00).isEqualsOrAfter (TIME_TO_COMPARE)
        ).isEqualTo(
            true
        );
    }

    @Test
    public void returns_true_if_check_in_is_after_time() {
        assertThat(
            new CheckIn(23,30).isEqualsOrAfter (TIME_TO_COMPARE)
        ).isEqualTo(
            true
        );
    }
}