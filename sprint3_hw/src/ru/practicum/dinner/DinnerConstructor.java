package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnersByType = new HashMap<>(); // хранилище блюд
    Random random = new Random(); // класс для случайного выбора

    // добавление блюда
    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishesForType; // список блюд данного типа

        if (dinnersByType.containsKey(dishType)) { // проверяем наличие типа
            dishesForType = dinnersByType.get(dishType); // получаем существующий список
        } else {
            dishesForType = new ArrayList<>(); // создаём новый список
            dinnersByType.put(dishType, dishesForType); // сохраняем его в хранилище
        }

        dishesForType.add(dishName); // добавляем блюдо
    }

    // генерация комбинаций
    public ArrayList<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>(); // список комбинаций

        for (int i = 0; i < comboNumber; i++) {
            ArrayList<String> combo = generateCombo(dishTypes);
            combos.add(combo);
        }

        return combos;
    }

    // проверка наличия типа блюда
    public boolean checkType(String type) {
        return dinnersByType.containsKey(type);
    }

    // генерация одной комбинации
    private ArrayList<String> generateCombo(ArrayList<String> dishTypes) {
        ArrayList<String> selectedDishes = new ArrayList<>();

        for (String dishType : dishTypes) {
            ArrayList<String> availableDishes = dinnersByType.get(dishType);
            String selectedDish = getRandomDish(availableDishes);
            selectedDishes.add(selectedDish);
        }

        return selectedDishes;
    }

    // получение случайного блюда
    private String getRandomDish(ArrayList<String> availableDishes) {
        int numberOfDishesForType = availableDishes.size();
        int dishIndex = random.nextInt(numberOfDishesForType);
        String selectedDish = availableDishes.get(dishIndex);
        return selectedDish;
    }

}