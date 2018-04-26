package fr.lcdlv.promo05.socratesfr.dietmeal;

import java.util.List;

public class DietMealCounter {
    public int count(Diet diet, List<Diet> choices) {

        int count = 0;
        for (Diet choice : choices) {
            if (choice.equals(diet)) {
                count++;
            }
        }
        return count;
        
    }
}
