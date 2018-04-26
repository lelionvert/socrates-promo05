package fr.lcdlv.promo05.coverTest;

import fr.lcdlv.promo05.covers.Cover;
import fr.lcdlv.promo05.covers.CoversRecord;
import fr.lcdlv.promo05.covers.DietType;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversRecordTest {


  @Test
  public void shouldReturns0IfNoCovers() {
    CoversRecord coversRecord = new CoversRecord(Collections.EMPTY_LIST);
    assertThat(coversRecord.getCoversNumber()).isEqualTo(0);
  }

  @Test
  public void shouldReturns1IfOneCover() {
    Cover cover = new Cover(DietType.VEGAN);
    CoversRecord coversRecord = new CoversRecord(Collections.singletonList(cover));

    assertThat(coversRecord.getCoversNumber()).isEqualTo(1);
  }

  @Test
  public void shouldReturns2If2Covers() {
    CoversRecord coversRecord = new CoversRecord(Arrays.asList(new Cover(DietType.VEGAN),new Cover(DietType.VEGAN))) ;
    assertThat(coversRecord.getCoversNumber()).isEqualTo(2);
  }

    @Test
    public void shouldReturns1VeganCoverif1SVeganDiet() {
        CoversRecord coversRecord = new CoversRecord(
            Collections.singletonList(new Cover(DietType.VEGAN))
        );
        assertThat(coversRecord.getCoversNumber(DietType.VEGAN)).isEqualTo(1);
    }
}
