package fr.lcldlv.promo5.coldMeals;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ColdMealsCounterTest {

    @Test
    public void should_return_0_if_no_checkIn_after_cold_meal_time_limit() {

        Assertions.assertThat(new ColdMealsCounter().countColdMeals(Arrays.asList()))
                .isEqualTo(0);
    }

    @Test
    public void should_return_0_if_a_checkIn_before_cold_meal_time_limit() {

        Assertions.assertThat(
                new ColdMealsCounter()
                        .countColdMeals(Arrays.asList(new CheckInTime(12))))
                .isEqualTo(0);
    }

    @Test
    public void should_return_1_if_the_checkIn_is_after_cold_meal_time_limit() {
        Assertions.assertThat(
                new ColdMealsCounter()
                        .countColdMeals(Arrays.asList(new CheckInTime(21))))
                .isEqualTo(1);
    }

    @Test
    public void should_return_1_if_one_before_and_one_after_cold_meal_time_limit() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                new CheckInTime(22),
                new CheckInTime(20)
        );
        Assertions.assertThat(
                new ColdMealsCounter().countColdMeals(checkInDates))
                .isEqualTo(1);
    }

    @Test
    public void should_return_2_if_two_checkIns_after_cold_meal_time_limit() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                new CheckInTime(22),
                new CheckInTime(21)
        );
        Assertions.assertThat(
                new ColdMealsCounter().countColdMeals(checkInDates))
                .isEqualTo(2);
    }

    @Test
    public void should_return_0_if_two_checkIns_before_cold_meal_time_limit() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                new CheckInTime(10),
                new CheckInTime(20)
        );
        Assertions.assertThat(
                new ColdMealsCounter().countColdMeals(checkInDates))
                .isEqualTo(0);
    }

}