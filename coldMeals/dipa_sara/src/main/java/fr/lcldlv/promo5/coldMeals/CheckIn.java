package fr.lcldlv.promo5.coldMeals;

class CheckIn {

    private final int hour;

    CheckIn(int hour) {
        this.hour = hour;
    }

    boolean isAfter(int time) {
        return this.hour >= time;
    }
}
