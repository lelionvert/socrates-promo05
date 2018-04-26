package fr.lcdlv.promo05.covers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoversRecord {

  private final List<Cover> covers;

  public CoversRecord(List<Cover> covers) {
    this.covers = covers;
  }

  public int getCoversNumber() {
    return this.covers.isEmpty() ? 0 : covers.size();
  }
}
