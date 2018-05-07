import java.util.List;

class ColdMealsCounter {

    public static final int COLD_MEAL_TIME = 21;

    public static int countColdMeals(List<CheckIn> checkIns) {
        return Math.toIntExact(checkIns
            .stream()
            .filter(checkIn -> checkIn.isAfter(COLD_MEAL_TIME))
            .count());
    }
}
