package fr.lcldlv.promo5.coldMeals;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ColdMealsCounterTest {

    @Test
    public void should_return_0_when_there_is_no_persons_check_in_on_thursday_after_21PM() {

        Assertions.assertThat(new ColdMealsCounter().count())
                .isEqualTo(0);
    }

    @Test
    public void should_return_0_when_the_check_in_date_is_before_thursday_21h00PM() {

        Assertions.assertThat(
                new ColdMealsCounter()
                        .count(Arrays.asList(new CheckInDate(12, 00))))
                .isEqualTo(0);
    }

    @Test
    public void should_return_1_when_the_check_in_date_is_thursday_21h00PM() {
        Assertions.assertThat(
                new ColdMealsCounter()
                        .count(Arrays.asList(new CheckInDate(21, 00))))
                .isEqualTo(1);
    }

    @Test
    public void should_return_1_when_there_is_one_before_limit_check_in_date_and_one_after_limit_check_in_date() {
        List<CheckInDate> checkInDates = Lists.newArrayList(
                new CheckInDate(22, 00),
                new CheckInDate(20, 00)
        );
        Assertions.assertThat(
                new ColdMealsCounter().count(checkInDates))
                .isEqualTo(1);
    }
}