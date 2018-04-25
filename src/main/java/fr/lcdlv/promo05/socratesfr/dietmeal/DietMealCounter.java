package fr.lcdlv.promo05.socratesfr.dietmeal;

import java.util.List;

public class DietMealCounter {
    public int count(String diet, List<String> choices) {

        int count = 0;
        for (String choice : choices) {
            if (choice.equals(diet)) {
                count++;
            }
        }
        return count;
        
    }
}
