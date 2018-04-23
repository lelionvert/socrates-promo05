package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;


import java.time.LocalTime;

public class CheckInTest {
  @Test
  public void returnsFalseIfTimeIsBefore9PM() {
    Assertions.assertThat(
        new CheckIn(LocalTime.of (20,59)).isAfter9PM()
    ).isEqualTo (
        false
    );
  }

  @Test
  public void returnsTrueIfTimeIs9PM() {
    Assertions.assertThat(
        new CheckIn(LocalTime.of (21,00)).isAfter9PM()
    ).isEqualTo (
        true
    );
  }

  @Test
  public void returnsTrueIfTimeIsAfter9PM() {
    Assertions.assertThat(
            new CheckIn(LocalTime.of (23,30)).isAfter9PM()
    ).isEqualTo (
            true
    );
  }
}
