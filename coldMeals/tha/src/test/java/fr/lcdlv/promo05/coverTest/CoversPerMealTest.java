package fr.lcdlv.promo05.coverTest;
import fr.lcdlv.promo05.covers.Meal;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversPerMealTest {

  @Test
  public void shouldReturns0IfNoCovers() {
    Meal meal = new Meal();

    assertThat(meal.getCovers()).isEqualTo(0);
  }
}
