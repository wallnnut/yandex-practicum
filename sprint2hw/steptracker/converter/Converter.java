package ru.practicum.steptracker.converter;

public class Converter {
    private static final int STEP_COEFICIENT = 75;
    private static final int CALORY_COEFICIENT = 50;

    public String convertStepsToKm(int steps) {
        int distanceInSm = steps * STEP_COEFICIENT;
        int distanceInKm = distanceInSm / 100000;

        return String.format("%d км", distanceInKm);
    }

    public String calculateCalories(int steps) {
        int calories = steps * CALORY_COEFICIENT;
        return String.format("%d ккал", calories / 1000);
    }
}
