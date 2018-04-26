package fr.lcdlv.promo05.coverTest;

import fr.lcdlv.promo05.covers.Cover;
import fr.lcdlv.promo05.covers.CoversRecord;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversRecordTest {

  private CoversRecord coversRecord;

  @Before
  public void setUp() throws Exception {
    coversRecord = new CoversRecord(null);
  }

  @Test
  public void shouldReturns0IfNoCovers() {
    assertThat(coversRecord.getCoversNumber()).isEqualTo(0);
  }

  @Test
  public void shouldReturns1IfOneCover() {
    CoversRecord coversRecord = new CoversRecord(new Cover());

    assertThat(coversRecord.getCoversNumber()).isEqualTo(1);
  }

}
