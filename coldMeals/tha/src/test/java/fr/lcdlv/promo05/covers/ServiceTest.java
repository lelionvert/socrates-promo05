package fr.lcdlv.promo05.covers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

  @Test
  public void returns0IfNoCovers() {
    @SuppressWarnings("unchecked") Service service = new Service(Collections.EMPTY_LIST);

    assertThat(service.getCoversNumber()).isEqualTo(0);
  }

  @Test
  public void returns1IfOneCover() {
    Service service = new Service(
        Collections.singletonList(new Cover(DietType.VEGAN))
    );

    assertThat(service.getCoversNumber()).isEqualTo(1);
  }

  @Test
  public void returns2If2Covers() {
    Service service = new Service(
        List.<Cover>of(
            new Cover(DietType.VEGAN),
            new Cover(DietType.VEGAN)
        )
    );

    assertThat(service.getCoversNumber()).isEqualTo(2);
  }

  @Test
  public void returns1VeganCoverIf1SVeganDiet() {
    Service service = new Service(
        Collections.singletonList(new Cover(DietType.VEGAN))
    );

    assertThat(service.getCoversNumber(DietType.VEGAN)).isEqualTo(1);
  }

  @Test
  public void returns2VeganCoverIf2VeganDiet() {
    Service service = new Service(
        List.<Cover>of(
            new Cover(DietType.VEGAN),
            new Cover(DietType.VEGAN)
        )
    );

    assertThat(service.getCoversNumber(DietType.VEGAN)).isEqualTo(2);
  }

  @Test
  public void returns1VeganCoverIf1VeganDietAndAnotherDiet() {
    Service service = new Service(
        List.<Cover>of(
            new Cover(DietType.VEGAN),
            new Cover(DietType.VEGETARIAN)
        )
    );

    assertThat(service.getCoversNumber(DietType.VEGAN)).isEqualTo(1);
  }

  @Test
  public void returns1VegetarianCoverIf1VegetarianAndAnotherDiet() {
    Service service = new Service(
        Arrays.asList(
            new Cover(DietType.VEGAN),
            new Cover(DietType.VEGETARIAN)
        )
    );

    assertThat(service.getCoversNumber(DietType.VEGETARIAN)).isEqualTo(1);
  }

  @Test
  public void returns2VegetarianCoverIf1VegetarianAndAnotherDiet() {
    Service service = new Service(
        Arrays.asList(
            new Cover(DietType.VEGAN),
            new Cover(DietType.VEGETARIAN)
        )
    );

    assertThat(service.getCovers())
        .containsEntry(DietType.VEGAN, 1)
        .containsEntry(DietType.VEGETARIAN, 1)
        .containsEntry(DietType.OMNIVOROUS, 0)
        .containsEntry(DietType.PECESTARIAN, 0);
  }
}
