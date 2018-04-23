package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountColdMealsTest {

  @Test
  public void noParticipants() {
    List<CheckIn> participants = new ArrayList<>();

    Assertions.assertThat(
        Planning.countColdMeals(participants)
    ).isEqualTo(0);
  }
}