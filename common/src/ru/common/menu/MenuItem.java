package ru.common.menu;

public class MenuItem {
    private String name;
    private int position;
    private Runnable action;

    public MenuItem(String name, int position, Runnable action) {
        this.name = name;
        this.position = position;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void execute() {
        action.run();
    }
}
