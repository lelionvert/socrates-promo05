package fr.lcdlv.promo05.covers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class Service {

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

    public Map<DietType, Long> getCovers() {
      return covers
          .stream()
          .collect(
              groupingBy(Cover::getDietType,  counting())
          );
    }
}
