package fr.lcdlv.promo05.socrates;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountColdMealsTest {

  @Test
  public void returns_0_if_checkins_are_empty() {
    List<CheckIn> checkIns = new ArrayList<>();

    Assertions.assertThat(
        ColdMealsCounter.countColdMeals(checkIns)
    ).isEqualTo(0);
  }

  @Test
  public void returns_collection_size_if_all_checkins_are_after_cold_meal_time() {
    List<CheckIn> checkIns = Arrays.asList (
        new CheckIn(22,30),
        new CheckIn(23,30),
        new CheckIn(22,33)
    );

    Assertions.assertThat(
        ColdMealsCounter.countColdMeals(checkIns)
    ).isEqualTo(checkIns.size());
  }

  @Test
  public void returns_0_if_checkins_has_no_item_after_cold_meal_time() {
    List<CheckIn> checkIns = Arrays.asList(
        new CheckIn(10, 30),
        new CheckIn(11, 45),
        new CheckIn(11, 45)
    );

    Assertions.assertThat(
        ColdMealsCounter.countColdMeals(checkIns)
    ).isEqualTo(
        0
    );
  }

  @Test
  public void returns_1_if_checkins_has_one_item_after_cold_meal_time() {
    List<CheckIn> checkIns = Arrays.asList(
        new CheckIn(10, 30),
        new CheckIn(11, 45),
        new CheckIn(23, 45),
        new CheckIn(11, 45)
    );

    Assertions.assertThat(
        ColdMealsCounter.countColdMeals(checkIns)
    ).isEqualTo(
        1
    );
  }
}