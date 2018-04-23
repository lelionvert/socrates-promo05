package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;


import java.time.LocalTime;

public class CheckInTest {

  @Test
  public void before9PMIsNotTooLate() {
    Assertions.assertThat(
        new CheckIn(20,59).isTooLate()
    ).isEqualTo(
        false
    );
  }

  @Test
  public void at9PMIsTooLate() {
    Assertions.assertThat(
        new CheckIn(21,00).isTooLate()
    ).isEqualTo(
        true
    );
  }

  @Test
  public void after9PMIsTooLate() {
    Assertions.assertThat(
        new CheckIn(23,30).isTooLate()
    ).isEqualTo(
        true
    );
  }
}
