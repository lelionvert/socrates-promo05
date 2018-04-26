package fr.lcdlv.promo05.socratesfr.dietmeal;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CoversCounterTest {

    private CoversCounter coversCounter;

    @Before
    public void setUp() throws Exception {
        coversCounter = new CoversCounter();
    }

    @Test
    public void counting_vegan_covers_should_return_0_if_no_choices() {
        Choices emptyChoices = new Choices(new ArrayList<>());
        Assertions.assertThat(this.coversCounter.count(Menu.VEGAN, emptyChoices)).isEqualTo(0);
    }

    @Test
    public void counting_vegan_covers_should_return_1_if_vegan_is_the_only_choice() {
        Choices one_vegan_choice = new Choices(Collections.singletonList(Menu.VEGAN));
        Assertions.assertThat(this.coversCounter.count(Menu.VEGAN, one_vegan_choice)).isEqualTo(1);
    }

    @Test
    public void counting_vegan_covers_should_return_1_if_vegan_is_one_of_the_choices() {
        Choices with_one_vegan_choice = new Choices(Arrays.asList(Menu.VEGETARIAN, Menu.VEGAN));
        Assertions.assertThat(coversCounter.count(Menu.VEGAN, with_one_vegan_choice)).isEqualTo(1);
    }

    @Test
    public void counting_vegan_covers_should_return_choices_size_if_vegan_is_all_the_choices() {
        Choices all_choices_are_vegan = new Choices(Arrays.asList(Menu.VEGAN, Menu.VEGAN));
        Assertions.assertThat(coversCounter.count(Menu.VEGAN, all_choices_are_vegan)).isEqualTo(all_choices_are_vegan.size());
    }

    @Test
    public void counting_vegan_covers_should_return_0_if_vegan_is_not_present_in_choices() {
        Choices no_vegan_choice = new Choices(Arrays.asList(Menu.VEGETARIAN, Menu.VEGETARIAN, Menu.PESCATARIAN));
        Assertions.assertThat(coversCounter.count(Menu.VEGAN, no_vegan_choice)).isEqualTo(0);
    }


}