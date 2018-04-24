package fr.lcdlv.promo05.socrates;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInTest {

  @Test
  public void before9PMIsNotTooLate() {
    assertThat(
        new CheckIn(20,59).isEqualsOrAfter (CheckIn.COLD_MEALS_TIME)
    ).isEqualTo(
        false
    );
  }

  @Test
  public void at9PMIsTooLate() {
    assertThat(
        new CheckIn(21,00).isEqualsOrAfter (CheckIn.COLD_MEALS_TIME)
    ).isEqualTo(
        true
    );
  }

  @Test
  public void after9PMIsTooLate() {
    assertThat(
        new CheckIn(23,30).isEqualsOrAfter (CheckIn.COLD_MEALS_TIME)
    ).isEqualTo(
        true
    );
  }
}
