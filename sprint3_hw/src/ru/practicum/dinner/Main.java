package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;

import ru.common.input.UserInput;
import ru.common.menu.MenuItem;
import ru.common.menu.MenuList;

public class Main {

    static DinnerConstructor dinnerConstructor = new DinnerConstructor();;
    static UserInput userInput = new UserInput();
    static MenuList menuList = new MenuList();

    public static void main(String[] args) {
        menuList.addMenuOptions(new ArrayList<>(List.of(
                new MenuItem("Добавить новое блюдо", 1, () -> {
                    System.out.println("Option1");
                }),
                new MenuItem("Сгенерировать комбинации блюд", 2, () -> {
                    System.out.println("Option2");
                }),
                new MenuItem("Выход", 3, () -> {
                    System.out.println("Option3");
                }))));

        int choice = 0;

        while (choice != 3) {
            menuList.drawMenu();
            try {
                choice = userInput.readInt();
                menuList.select(choice);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }

        }

    }
}
