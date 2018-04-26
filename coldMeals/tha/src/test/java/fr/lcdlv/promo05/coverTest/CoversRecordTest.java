package fr.lcdlv.promo05.coverTest;

import fr.lcdlv.promo05.covers.Cover;
import fr.lcdlv.promo05.covers.CoversRecord;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversRecordTest {

  private CoversRecord coversRecord;

  @Test
  public void shouldReturns0IfNoCovers() {
    coversRecord = new CoversRecord(null);

    assertThat(coversRecord.getCoversNumber()).isEqualTo(0);
  }

  @Test
  public void shouldReturns1IfOneCover() {
    CoversRecord coversRecord = new CoversRecord(new Cover());

    assertThat(coversRecord.getCoversNumber()).isEqualTo(1);
  }

  @Test
  public void shouldReturns2If2Covers() {
    assertThat(coversRecord.getCoversNumber()).isEqualTo(2);
  }
}
