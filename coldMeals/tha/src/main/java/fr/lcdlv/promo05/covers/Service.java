package fr.lcdlv.promo05.covers;

import java.util.List;

public class Service {

  private final List<Cover> covers;

  public Service(List<Cover> covers) {
    this.covers = covers;
  }

  public int getCoversNumber() {
    return covers.size();
  }

  public int getCoversNumber(DietType dietType) {
    return Math.toIntExact(
        covers
            .stream()
            .filter(cover -> cover.getDietType() == dietType)
            .count()
    );
  }
}
