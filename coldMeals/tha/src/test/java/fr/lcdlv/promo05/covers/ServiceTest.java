package fr.lcdlv.promo05.covers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class ServiceTest {

  @Test
  public void shouldReturns0IfNoCovers() {
    Service service = new Service(Collections.EMPTY_LIST);
    assertThat(service.getCoversNumber()).isEqualTo(0);
  }

  @Test
  public void shouldReturns1IfOneCover() {
    Cover cover = new Cover(DietType.VEGAN);
    Service service = new Service(Collections.singletonList(cover));

    assertThat(service.getCoversNumber()).isEqualTo(1);
  }

  @Test
  public void shouldReturns2If2Covers() {
    Service service = new Service(Arrays.asList(new Cover(DietType.VEGAN),new Cover(DietType.VEGAN))) ;
    assertThat(service.getCoversNumber()).isEqualTo(2);
  }

    @Test
    public void shouldReturns1VeganCoverIf1SVeganDiet() {
        Service service = new Service(
            Collections.singletonList(new Cover(DietType.VEGAN))
        );
        assertThat(service.getCoversNumber(DietType.VEGAN)).isEqualTo(1);
    }

  @Test
  public void shouldReturns2VeganCoverIf2VeganDiet() {
    Service service = new Service(
        Arrays.asList(new Cover(DietType.VEGAN), new Cover(DietType.VEGAN))
    );
    assertThat(service.getCoversNumber(DietType.VEGAN)).isEqualTo(2);
  }

    @Test
    public void shouldReturns1VeganCoverIf1VeganDietAndAnotherDiet() {
        Service service = new Service(
                Arrays.asList(new Cover(DietType.VEGAN), new Cover(DietType.VEGETARIAN))
        );
        assertThat(service.getCoversNumber(DietType.VEGAN)).isEqualTo(1);
    }

  @Test
  public void shouldReturns1VegetarianCoverIf1VegetarianAndAnotherDiet() {
    Service service = new Service(
        Arrays.asList(new Cover(DietType.VEGAN), new Cover(DietType.VEGETARIAN))
    );
    assertThat(service.getCoversNumber(DietType.VEGETARIAN)).isEqualTo(1);
  }

  @Test
  public void shouldReturns2VegetarianCoverIfg1VegetarianAndAnotherDiet() {
    Service service = new Service(
        Arrays.asList(
            new Cover(DietType.VEGAN),
            new Cover(DietType.VEGETARIAN)
        )
    );

    assertThat(
        service.getCovers())
        .hasSize(2)
        .contains(entry(DietType.VEGAN, 1L), entry(DietType.VEGETARIAN, 1L)
        );
  }


}
