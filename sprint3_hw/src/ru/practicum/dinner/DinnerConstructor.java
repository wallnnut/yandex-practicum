package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ru.common.random.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnersByType = new HashMap<>(); // хранилище блюд
    Random random = new Random(); // класс для случайного выбора

    public void addNewDish(String dishType, String dishName) {
        dinnersByType.computeIfAbsent(dishType, k -> new ArrayList<>()).add(dishName);
    }

    public List<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>(); // список комбинаций

        for (int i = 0; i < comboNumber; i++) {
            ArrayList<String> combo = generateCombo(dishTypes);
            combos.add(combo);
        }

        return combos;
    }

    public boolean checkType(String type) {
        return dinnersByType.containsKey(type);
    }

    private ArrayList<String> generateCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();

        for (String dishType : dishTypes) {
            ArrayList<String> availableDishes = dinnersByType.get(dishType);
            String selectedDish = getRandomDish(availableDishes);
            selectedDishes.add(selectedDish);
        }

        return selectedDishes;
    }

    private String getRandomDish(ArrayList<String> availableDishes) {
        int numberOfDishesForType = availableDishes.size();
        int dishIndex = random.nextInt(numberOfDishesForType);
        return availableDishes.get(dishIndex);

    }

}