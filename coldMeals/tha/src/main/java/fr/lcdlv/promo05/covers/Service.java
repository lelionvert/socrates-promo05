package fr.lcdlv.promo05.covers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

class Service {

  private final List<Cover> covers;

  Service(List<Cover> covers) {
    this.covers = covers;
  }

  int getCoversNumber() {
    return covers.size();
  }

  int getCoversNumber(DietType dietType) {
    return Math.toIntExact(
        covers
            .stream()
            .filter(cover -> cover.getDietType() == dietType)
            .count()
    );
  }

    Map<DietType, Integer> getCovers() {
      return Arrays
          .stream(DietType.values())
          .collect(
              toMap(
                  Function.identity(),
                  this::getCoversNumber
              )
          );
    }
}
