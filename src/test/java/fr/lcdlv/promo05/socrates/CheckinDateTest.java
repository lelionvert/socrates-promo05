package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckinDateTest {
  @Test
  public void returnsTrueIfDateIsOnThursdayAt9PM() {
    Assertions.assertThat(
        new CheckinDate().isAfter9PM()
    ).equalsTo(
        true
    );
  }
}
