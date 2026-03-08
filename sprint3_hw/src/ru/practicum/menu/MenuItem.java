package ru.practicum.menu;

public class MenuItem {
    private String name;
    private int position;

    public MenuItem(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
