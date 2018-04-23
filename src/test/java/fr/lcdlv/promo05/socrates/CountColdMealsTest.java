package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountColdMealsTest {

  @Test
  public void noParticipant() {
    List<CheckIn> participants = new ArrayList<>();

    Assertions.assertThat(
        Planning.countColdMeals(participants)
    ).isEqualTo(0);
  }

  @Test
  public void oneLateParticipant() {
    List<CheckIn> participants =Arrays.asList (new CheckIn ( 10,30));

    Assertions.assertThat(
            Planning.countColdMeals(participants)
    ).isEqualTo(1);
  }
  @Test
  public void allParticipantsAreLate() {
    List<CheckIn> participants =Arrays.asList (new CheckIn ( 22,30),new CheckIn ( 23,30),new CheckIn ( 22,33));

    Assertions.assertThat(
            Planning.countColdMeals(participants)
    ).isEqualTo(3);
  }
}