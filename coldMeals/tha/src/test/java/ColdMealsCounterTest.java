import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.ArrayList;

public class ColdMealsCounterTest {

    @Test
    public void should_return_no_cold_meals_if_no_participants() {
        ArrayList<CheckIn> checkIns = new ArrayList<>();
        Assertions.assertThat(ColdMealsCounter.countColdMeals(checkIns)).isEqualTo(0);
    }

    @Test
    public void should_return_0_if_1_check_in_before_21() {
        ArrayList<CheckIn> checkIns = new ArrayList<>();
        checkIns.add(CheckIn.CheckInFactory.createFor(20));
        Assertions.assertThat(ColdMealsCounter.countColdMeals(checkIns)).isEqualTo(0);
    }

    @Test
    public void should_return_1_if_1_check_in_after_21() {
        ArrayList<CheckIn> checkIns = new ArrayList<>();
        checkIns.add(CheckIn.CheckInFactory.createFor(22));
        Assertions.assertThat(ColdMealsCounter.countColdMeals(checkIns)).isEqualTo(1);
    }

    @Test
    public void should_return_0_if_2_check_in_before_21() {
        ArrayList<CheckIn> checkIns = new ArrayList<>();
        checkIns.add(CheckIn.CheckInFactory.createFor(20));
        checkIns.add(CheckIn.CheckInFactory.createFor(20));
        Assertions.assertThat(ColdMealsCounter.countColdMeals(checkIns)).isEqualTo(0);
    }

    @Test
    public void should_return_2_if_2_check_in_after_21() {
        ArrayList<CheckIn> checkIns = new ArrayList<>();
        checkIns.add(CheckIn.CheckInFactory.createFor(22));
        checkIns.add(CheckIn.CheckInFactory.createFor(22));
        Assertions.assertThat(ColdMealsCounter.countColdMeals(checkIns)).isEqualTo(2);
    }

    @Test
    public void should_return_1_if_1_check_in_before_21_and_1_check_in_after_21() {
        ArrayList<CheckIn> checkIns = new ArrayList<>();
        checkIns.add(CheckIn.CheckInFactory.createFor(22));
        checkIns.add(CheckIn.CheckInFactory.createFor(20));
        Assertions.assertThat(ColdMealsCounter.countColdMeals(checkIns)).isEqualTo(1);
    }
}