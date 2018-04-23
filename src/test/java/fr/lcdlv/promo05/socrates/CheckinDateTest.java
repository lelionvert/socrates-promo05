package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.DateUtil;
import org.junit.Test;


import java.time.LocalTime;

import static org.junit.Assert.*;

public class CheckinDateTest {
  @Test
  public void returnsFalseIfTimeIsBefore9PM() {
    Assertions.assertThat(
        new CheckinDate(LocalTime.of (20,59)).isAfter9PM()
    ).isEqualTo (
        true
    );
  }
}
