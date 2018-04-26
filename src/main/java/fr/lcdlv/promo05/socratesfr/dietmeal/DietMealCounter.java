package fr.lcdlv.promo05.socratesfr.dietmeal;

import java.util.List;

public class DietMealCounter {
    public int of(Menu menu, List<Menu> choices) {

        int count = 0;
        for (Menu choice : choices) {
            if (choice.equals(menu)) {
                count++;
            }
        }
        return count;
        
    }
}
