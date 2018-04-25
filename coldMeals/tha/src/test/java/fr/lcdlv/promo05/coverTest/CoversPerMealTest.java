package fr.lcdlv.promo05.coverTest;

import fr.lcdlv.promo05.covers.Meal;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversPerMealTest {

    private Meal meal;

    @Before
    public void setUp() throws Exception {
        meal = new Meal();
    }

    @Test
    public void shouldReturns0IfNoCovers() {
        assertThat(meal.getCoversNumber()).isEqualTo(0);
    }

    @Test
    public void shouldReturns1IfOneCover() {
        Meal meal =new Meal(1);
        assertThat(meal.getCoversNumber()).isEqualTo(1);
        }

}
