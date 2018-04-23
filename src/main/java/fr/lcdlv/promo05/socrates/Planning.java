package fr.lcdlv.promo05.socrates;


import java.util.List;

public class Planning {

  public static int countColdMeals(final List<CheckIn> participants) {

    return participants != null && participants.size () > 0 ? participants.size () : 0;
  }
}
