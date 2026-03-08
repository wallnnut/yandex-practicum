package ru.practicum.menu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MenuList {
    private ArrayList<MenuItem> list;

    public void drawMenu() {
        list.forEach(item -> System.out.printf("%d. %s%n", item.getPosition(), item.getName()));
    }

    public void addMenuOptions(List<MenuItem> options) {
        options.sort(Comparator.comparingInt(MenuItem::getPosition));
        list = new ArrayList<>(options);
    }

    public String getAvailableOptions() {
        return String.format("%d - %d%n", list.getFirst().getPosition(), list.getLast().getPosition());
    }
}
