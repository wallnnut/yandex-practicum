package ru.common.menu;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenuList {
    private final Map<Integer, MenuItem> menuMap = new LinkedHashMap<>();

    public void drawMenu() {
        menuMap.values().stream()
                .forEach(item -> System.out.printf("%d. %s%n", item.getPosition(), item.getName()));
    }

    public void addMenuOptions(List<MenuItem> options) {
        options.sort(Comparator.comparingInt(MenuItem::getPosition));
        menuMap.clear();
        for (MenuItem item : options) {
            menuMap.put(item.getPosition(), item);
        }
    }

    public void select(int choice) {
        MenuItem item = menuMap.get(choice);
        if (item != null) {
            item.execute();
        } else {
            System.out.println("Неверный выбор");
        }
    }

    public String getAvailableOptions() {
        if (menuMap.isEmpty())
            return "Меню пустое";
        int min = Collections.min(menuMap.keySet());
        int max = Collections.max(menuMap.keySet());
        return String.format("Выберите пункт: %d - %d%n", min, max);
    }
}
