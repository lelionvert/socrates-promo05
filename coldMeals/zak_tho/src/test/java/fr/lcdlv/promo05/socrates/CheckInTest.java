package fr.lcdlv.promo05.socrates;

import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInTest {

  public static final LocalTime TIME_TO_COMPARE = LocalTime.of (21, 00);

  @Test
  public void before9PMIsNotTooLate() {
    assertThat(
        new CheckIn(20,59).isEqualsOrAfter (TIME_TO_COMPARE)
    ).isEqualTo(
        false
    );
  }

  @Test
  public void at9PMIsTooLate() {
    assertThat(
        new CheckIn(21,00).isEqualsOrAfter (TIME_TO_COMPARE)
    ).isEqualTo(
        true
    );
  }

  @Test
  public void after9PMIsTooLate() {
    assertThat(
        new CheckIn(23,30).isEqualsOrAfter (TIME_TO_COMPARE)
    ).isEqualTo(
        true
    );
  }
}
