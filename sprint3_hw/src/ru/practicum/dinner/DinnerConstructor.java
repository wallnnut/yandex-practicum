package ru.practicum.dinner;

import java.util.*;

public class DinnerConstructor {
    HashMap<String, Set<String>> dinnersByType = new HashMap<>(); // хранилище блюд
    Random random = new Random(); // класс для случайного выбора

    public void addNewDish(String dishType, String dishName) {
        dinnersByType.computeIfAbsent(dishType, k -> new HashSet<>()).add(dishName);
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
            Set<String> availableDishes = dinnersByType.get(dishType);
            String selectedDish = getRandomDish(availableDishes);
            selectedDishes.add(selectedDish);
        }

        return selectedDishes;
    }

    private String getRandomDish(Set<String> availableDishes) {
        List<String> dishes = new ArrayList<>(availableDishes);
        int dishIndex = random.nextInt(availableDishes.size());
        return dishes.get(dishIndex);

    }

}