package fr.lcldlv.promo5.coldMeals;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ColdMealsTest {

    @Test
    public void should_return_0_when_there_is_no_persons_checking_on_thursday_after_21PM() {

        int numberOfColdMeals = new ColdMeals().count();
        Assertions.assertThat(numberOfColdMeals)
                .isEqualTo(0);

    }

    @Test
    public void should_return_0_when_the_checking_date_is_a_thursday_noon() throws Exception {

        Assertions.assertThat(
                new ColdMeals(new CheckInDate(12, 00)).count())
                .isEqualTo(0);
    }
}