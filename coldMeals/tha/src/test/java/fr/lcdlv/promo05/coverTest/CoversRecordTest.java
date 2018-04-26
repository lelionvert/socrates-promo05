package fr.lcdlv.promo05.coverTest;

import fr.lcdlv.promo05.covers.Cover;
import fr.lcdlv.promo05.covers.CoversRecord;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class CoversRecordTest {


  @Test
  public void shouldReturns0IfNoCovers() {
    CoversRecord coversRecord = new CoversRecord((Cover) null);
    assertThat(coversRecord.getCoversNumber()).isEqualTo(0);
  }

  @Test
  public void shouldReturns1IfOneCover() {
    CoversRecord coversRecord = new CoversRecord(new Cover());

    assertThat(coversRecord.getCoversNumber()).isEqualTo(1);
  }

  @Test
  public void shouldReturns2If2Covers() {
    CoversRecord coversRecord = new CoversRecord(Arrays.asList(new Cover(),new Cover())) ;
    assertThat(coversRecord.getCoversNumber()).isEqualTo(2);
  }
}
