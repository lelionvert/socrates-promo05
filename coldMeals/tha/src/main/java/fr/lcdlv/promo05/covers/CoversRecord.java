package fr.lcdlv.promo05.covers;

import java.util.Collections;
import java.util.List;

public class CoversRecord {

  private final Cover cover;
  private final List<Cover> covers;

  public CoversRecord(Cover cover) {
    this.cover = cover;
    this.covers = this.cover == null ? Collections.EMPTY_LIST : Collections.singletonList(cover);
  }

  public CoversRecord(List<Cover> covers) {
    this.covers = covers;
    this.cover = null;
  }

  public int getCoversNumber() {
    return this.covers.isEmpty() ? 0 : covers.size();
  }
}
