package fr.lcdlv.promo05.socratesfr.dietmeal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DietMealCounterTest {

    @Test
    public void return_0_if_no_choices() {
         List<Diet> choices = new ArrayList<>();
        DietMealCounter dietMealCounter = new DietMealCounter();
        Assertions.assertThat(dietMealCounter.count(Diet.VEGAN, choices)).isEqualTo(0);
    }

    @Test
    public void return_1_if_1_vegan_choice() {
         List<Diet> choices = Collections.singletonList(Diet.VEGAN);
        DietMealCounter dietMealCounter = new DietMealCounter();
        Assertions.assertThat(dietMealCounter.count(Diet.VEGAN, choices)).isEqualTo(1);
    }

    @Test
    public void return_1_if_1_vegan_and_1_vegetarian_choices() {
        DietMealCounter dietMealcounter = new DietMealCounter();
         List<Diet> choices = Arrays.asList(Diet.VEGETARIAN, Diet.VEGAN);
        Assertions.assertThat(dietMealcounter.count(Diet.VEGAN, choices)).isEqualTo(1);
    }

    @Test
    public void return_2_if_2_of_choice() throws Exception {
        DietMealCounter dietMealcounter = new DietMealCounter();
         List<Diet> choices = Arrays.asList(Diet.VEGAN, Diet.VEGAN);
        Assertions.assertThat(dietMealcounter.count(Diet.VEGAN, choices)).isEqualTo(2);
    }

    @Test
    public void return_0_if_choice_not_present() throws Exception {
        DietMealCounter dietMealcounter = new DietMealCounter();
         List<Diet> choices = Arrays.asList(Diet.VEGAN, Diet.VEGAN);
        Assertions.assertThat(dietMealcounter.count(Diet.VEGETARIAN, choices)).isEqualTo(0);
    }

}