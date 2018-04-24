package fr.lcdlv.promo05.socrates;

import java.util.List;

class Planning {

  public static int countColdMeals(final List<CheckIn> checkIns) {
    if (checkIns == null) {
      return 0;
    }

    return Math.toIntExact(
        checkIns
            .stream()
            .filter(CheckIn::isTooLate)
            .count()
    );
  }
}