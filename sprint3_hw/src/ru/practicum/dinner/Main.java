package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.List;

import ru.common.input.UserInput;
import ru.common.menu.MenuItem;
import ru.common.menu.MenuList;

public class Main {

    static DinnerConstructor dinnerConstructor = new DinnerConstructor();
    static UserInput userInput = new UserInput();
    static MenuList menuList = new MenuList();

    public static void main(String[] args) {
        System.out.println("Введите тип блюда:");
        menuList.addMenuOptions(new ArrayList<>(List.of(new MenuItem("Добавить новое блюдо", 1, Main::addNewDish),
                new MenuItem("Сгенерировать комбинации блюд", 2, Main::generateDishCombo),
                new MenuItem("Выход", 3, Main::noop))));

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

    private static void noop() {
        /**
         * Метод пуст так как используется при выходе по заданию при выходе нет
         * необходимости выполнять дополнительные действия
         */
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = userInput.readLine();
        System.out.println("Введите название блюда:");
        String dishName = userInput.readLine();

        dinnerConstructor.addNewDish(dishType, dishName);
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
            if (dinnerConstructor.checkType(nextItem)) {

                selectedTypes.add(nextItem);
            } else {
                System.out.println("Такой тип блюд мы еще не умеем готовить. Попробуйте что-нибудь другое!");
            }
            nextItem = userInput.readLine();
        }
        List<ArrayList<String>> generatedCombos = dinnerConstructor.generateCombos(numberOfCombos, selectedTypes);
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация " + (i + 1));
            System.out.println(generatedCombos.get(i));

        }
    }
}
