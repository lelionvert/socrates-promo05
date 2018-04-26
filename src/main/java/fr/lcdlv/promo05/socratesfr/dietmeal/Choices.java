package fr.lcdlv.promo05.socratesfr.dietmeal;

import java.util.List;

public class Choices {
    private final List<Menu> choices;

    public Choices(List<Menu> choices) {

        this.choices = choices;
    }

    public Menu get(int index) {
        return choices.get(index);
    }

    public  int size(){
        return choices.size();
    }


}
