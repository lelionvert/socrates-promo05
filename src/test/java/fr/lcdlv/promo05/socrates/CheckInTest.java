package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckInTest {

  @Test
  public void before9PMIsNotTooLate() {
    assertThat(
        new CheckIn(20,59).isTooLate()
    ).isEqualTo(
        false
    );
  }

  @Test
  public void at9PMIsTooLate() {
    assertThat(
        new CheckIn(21,00).isTooLate()
    ).isEqualTo(
        true
    );
  }

  @Test
  public void after9PMIsTooLate() {
    assertThat(
        new CheckIn(23,30).isTooLate()
    ).isEqualTo(
        true
    );
  }
}
