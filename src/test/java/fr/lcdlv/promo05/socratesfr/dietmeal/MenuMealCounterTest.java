package fr.lcdlv.promo05.socratesfr.dietmeal;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MenuMealCounterTest {


    private DietMealCounter dietMealCounter;

    @Before
    public void setUp() throws Exception {
        dietMealCounter = new DietMealCounter();
    }

    @Test
    public void counting_vegan_covers_should_return_0_if_no_choices() {
        List<Menu> choices = new ArrayList<>();
        Assertions.assertThat(this.dietMealCounter.count(Menu.VEGAN, new Choices(choices))).isEqualTo(0);
    }

    @Test
    public void counting_vegan_covers_should_return_1_if_vegan_is_the_only_choice() {
        List<Menu> choices = Collections.singletonList(Menu.VEGAN);
        Assertions.assertThat(this.dietMealCounter.count(Menu.VEGAN, new Choices(choices))).isEqualTo(1);
    }

    @Test
    public void counting_vegan_covers_should_return_1_if_vegan_is_one_of_the_choices() {
        List<Menu> choices = Arrays.asList(Menu.VEGETARIAN, Menu.VEGAN);
        Assertions.assertThat(dietMealCounter.count(Menu.VEGAN, new Choices(choices))).isEqualTo(1);
    }

    @Test
    public void counting_vegan_covers_should_return_choices_size_if_vegan_is_all_the_choices() {
        List<Menu> choices = Arrays.asList(Menu.VEGAN, Menu.VEGAN);
        Assertions.assertThat(dietMealCounter.count(Menu.VEGAN, new Choices(choices))).isEqualTo(choices.size());
    }

    @Test
    public void counting_vegan_covers_should_return_0_if_vegan_is_not_present_in_choices() {
        Assertions.assertThat(dietMealCounter.count(
                Menu.VEGAN, new Choices(Arrays.asList(Menu.VEGETARIAN, Menu.VEGETARIAN, Menu.PESCATARIAN)))).isEqualTo(0);
    }


}