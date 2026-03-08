package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;

import ru.practicum.input.UserInput;
import ru.practicum.menu.MenuItem;
import ru.practicum.menu.MenuList;

public class Main {

    static DinnerConstructor dinnerConstructor = new DinnerConstructor();;
    static UserInput userInput = new UserInput();
    static MenuList menuList = new MenuList();

    public static void main(String[] args) {
        menuList.addMenuOptions(new ArrayList<>(List.of(
                new MenuItem("Добавить новое блюдо", 1),
                new MenuItem("Сгенерировать комбинации блюд", 2),
                new MenuItem("Сгенерировать все возможные комбинации блюд", 3),
                new MenuItem("Выход", 4))));

        while (true) {
            menuList.drawMenu();
            String command = userInput.readLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    generateDishCombo();
                    break;
                case "4":
                    return;
            }
        }
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = userInput.readLine();
        System.out.println("Введите название блюда:");
        String dishName = userInput.readLine();
        dinnerConstructor.addDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = userInput.readInt();

        System.out.println(
                "Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = userInput.readLine();

        ArrayList<String> selectedTypes = new ArrayList<>();

        while (!nextItem.isEmpty()) {
            selectedTypes.add(nextItem);
            nextItem = userInput.readLine();

        }
        List<ArrayList<String>> combos = dinnerConstructor.generateCombos(selectedTypes);

        for (ArrayList<String> combo : combos) {
            System.out.println("Комбинация " + combos.indexOf(combo) + 1);
            System.out.println(String.join(", ", combo));
        }

    }

}
