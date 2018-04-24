package fr.lcldlv.promo5.coldMeals;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ColdMealsCounterTest {

    private final ColdMealsCounter coldMealsCounter = new ColdMealsCounter();
    private final CheckInTime checkInTimeBeforeColdMealsLimitTime = new CheckInTime(12);
    private final CheckInTime checkInTimeAfterColdMealsLimit = new CheckInTime(21);

    @Test
    public void should_return_0_if_no_checkIn_after_cold_meal_time_limit() {

        Assertions.assertThat(coldMealsCounter.countColdMeals(Arrays.asList()))
                .isEqualTo(0);
    }

    @Test
    public void should_return_0_if_a_checkIn_before_cold_meal_time_limit() {

        Assertions.assertThat(
                coldMealsCounter
                        .countColdMeals(Arrays.asList(checkInTimeBeforeColdMealsLimitTime)))
                .isEqualTo(0);
    }

    @Test
    public void should_return_1_if_the_checkIn_is_after_cold_meal_time_limit() {
        Assertions.assertThat(
                coldMealsCounter
                        .countColdMeals(Arrays.asList(checkInTimeAfterColdMealsLimit)))
                .isEqualTo(1);
    }

    @Test
    public void should_return_1_if_one_before_and_one_after_cold_meal_time_limit() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                checkInTimeBeforeColdMealsLimitTime,
                checkInTimeAfterColdMealsLimit
        );
        Assertions.assertThat(
                coldMealsCounter.countColdMeals(checkInDates))
                .isEqualTo(1);
    }

    @Test
    public void should_return_2_if_two_checkIns_after_cold_meal_time_limit() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                checkInTimeAfterColdMealsLimit,
                checkInTimeAfterColdMealsLimit
        );
        Assertions.assertThat(
                coldMealsCounter.countColdMeals(checkInDates))
                .isEqualTo(2);
    }

    @Test
    public void should_return_0_if_two_checkIns_before_cold_meal_time_limit() {
        List<CheckInTime> checkInDates = Lists.newArrayList(
                checkInTimeBeforeColdMealsLimitTime,
                checkInTimeBeforeColdMealsLimitTime
        );
        Assertions.assertThat(
                coldMealsCounter.countColdMeals(checkInDates))
                .isEqualTo(0);
    }

}