package fr.lcdlv.promo05.socratesfr.dietmeal;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DietMealCounterTest {
    @Test
    public void return_0_if_no_choices() throws Exception {
        List<String> choices = new ArrayList<>();
        DietMealCounter dietMealCounter = new DietMealCounter();
        Assertions.assertThat(dietMealCounter.count("VEGAN",choices)).isEqualTo(0);
    }
}