package fr.lcdlv.promo05.socratesfr.dietmeal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DietMealCounterTest {
    @Test
    public void return_0_if_no_choices() {
        List<String> choices = new ArrayList<>();
        DietMealCounter dietMealCounter = new DietMealCounter();
        Assertions.assertThat(dietMealCounter.count("VEGAN",choices)).isEqualTo(0);
    }
    @Test
    public void return_1_if_1_vegan_choice() {
        List<String> choices = Collections.singletonList("VEGAN");
        DietMealCounter dietMealCounter = new DietMealCounter();
        Assertions.assertThat(dietMealCounter.count("VEGAN",choices)).isEqualTo(1);
    }

    @Test
    public void return_1_if_1_vegan_and_1_vegetarian_choices() {
        DietMealCounter dietMealcounter = new DietMealCounter();
        List<String> choices = Arrays.asList("VEGETARIAN","VEGAN");
        Assertions.assertThat(dietMealcounter.count("VEGAN", choices)).isEqualTo(1);
    }

    


}