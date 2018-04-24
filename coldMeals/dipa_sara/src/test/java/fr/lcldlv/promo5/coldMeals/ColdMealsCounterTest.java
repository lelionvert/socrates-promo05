package fr.lcldlv.promo5.coldMeals;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ColdMealsCounterTest {

    @Test
    public void should_return_0_if_no_persons_check_in_after_limit_check_in() {

        Assertions.assertThat(new ColdMealsCounter().countColdMeals(Arrays.asList()))
                .isEqualTo(0);
    }

    @Test
    public void should_return_0_if_the_check_in_is_before_cold_meal_time() {

        Assertions.assertThat(
                new ColdMealsCounter()
                        .countColdMeals(Arrays.asList(new CheckInTime(12))))
                .isEqualTo(0);
    }

    @Test
    public void should_return_1_if_the_check_in_date_is_after_limit_check_in() {
        Assertions.assertThat(
                new ColdMealsCounter()
                        .countColdMeals(Arrays.asList(new CheckInTime(21))))
                .isEqualTo(1);
    }

    @Test
    public void should_return_1_if_one_before_limit_check_in_date_and_one_after_limit_check_in_date() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                new CheckInTime(22),
                new CheckInTime(20)
        );
        Assertions.assertThat(
                new ColdMealsCounter().countColdMeals(checkInDates))
                .isEqualTo(1);
    }

    @Test
    public void should_return_2_if_two_after_limit_check_in_dates() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                new CheckInTime(22),
                new CheckInTime(21)
        );
        Assertions.assertThat(
                new ColdMealsCounter().countColdMeals(checkInDates))
                .isEqualTo(2);
    }

    @Test
    public void should_return_0_if_two_before_limit_check_in_dates() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                new CheckInTime(10),
                new CheckInTime(20)
        );
        Assertions.assertThat(
                new ColdMealsCounter().countColdMeals(checkInDates))
                .isEqualTo(0);
    }

}