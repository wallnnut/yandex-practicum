package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DinnerConstructor {
    private final Map<String, ArrayList<String>> groupedDishesList = new HashMap<>();

    public void addDish(String category, String dishName) {
        System.out.printf("%s %s", category, dishName);
        ArrayList<String> existedList = groupedDishesList.getOrDefault(category, new ArrayList<>());
        existedList.add(dishName); // добавляем в список название блюда
        groupedDishesList.put(category, existedList);
        for (String c : groupedDishesList.keySet()) {
            System.out.println(c);
        }
    }

    public List<ArrayList<String>> generateCombos(List<String> categoriesList) {
        ArrayList<ArrayList<String>> dishesValues = new ArrayList<>();
        ArrayList<ArrayList<String>> preparedCombos = new ArrayList<>();

        for (String category : categoriesList) {
            ArrayList<String> valueByCategory = groupedDishesList.getOrDefault(category, new ArrayList<String>());
            System.out.println(valueByCategory);
            if (!valueByCategory.isEmpty()) {
                dishesValues.add(valueByCategory);
            }
        }
        dishesValues.sort(Comparator.comparingInt(ArrayList::size));
        int minElementLength = 0;
        try {
            minElementLength = dishesValues.getFirst().size();
        } catch (Exception e) {

        }

        if (minElementLength > 0) {
            for (int i = 0; i < minElementLength; i++) {
                for (ArrayList<String> dishesValue : dishesValues) {
                    preparedCombos.add(dishesValue);
                }
            }
        }
        System.out.println(dishesValues);
        return preparedCombos;

    }

}