package fr.lcdlv.promo05.socrates;


import java.util.List;

public class Planning {

  public static int countColdMeals(final List<CheckIn> checkIns) {

    return checkIns != null && checkIns.size () > 0 ? checkIns.size () : 0;
  }
}
