package fr.lcdlv.promo05.covers;

public class CoversRecord {

  private final Cover cover;

  public CoversRecord(Cover cover) {
    this.cover = cover;
  }

  public int getCoversNumber() {
    return cover == null ? 0 : 1;
  }
}
