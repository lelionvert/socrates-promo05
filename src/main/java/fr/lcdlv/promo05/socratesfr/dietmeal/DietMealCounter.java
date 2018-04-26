package fr.lcdlv.promo05.socratesfr.dietmeal;

public class DietMealCounter {
    public int count(Menu menu, Choices choices) {

        int count = 0;
        for (int i = 0; i < choices.size(); i++) {
            Menu choice = choices.get(i);
            if (choice.equals(menu)) {
                count++;
            }
        }
        return count;

    }
}
