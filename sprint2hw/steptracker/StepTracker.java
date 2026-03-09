package ru.practicum.steptracker;

import ru.practicum.common.menu.*;
import ru.practicum.steptracker.calendar.*;
import ru.practicum.common.input.UserInput;

import java.util.ArrayList;
import java.util.List;

import ru.practicum.steptracker.calendarinput.CalendarInput;

public class StepTracker {
    private CalendarInput input = new CalendarInput();
    MenuList menu = new MenuList();
    TrackingCalendar calendar;

    public StepTracker() {

        menu.addMenuOptions(new ArrayList<>(
                List.of(new MenuItem("Добавить цель на день", 1), new MenuItem("Ввести количество шагов за день", 2),
                        new MenuItem("Показать статистику", 3), new MenuItem("Завершить работу", 4))));

        this.calendar = new TrackingCalendar();

    }

    public void run() {
        boolean isRuning = true;
        while (isRuning) {
            menu.drawMenu();

            try {
                int menuOption = input.readInt();
                switch (menuOption) {
                case 1: {
                    int stepsCount = input.readStepsCount();
                    calendar.setAimStepsCount(stepsCount);
                    break;
                }
                case 2: {
                    int month = input.readMonth(calendar.getMonthCount());
                    int day = input.readDay(calendar.getMonth(month).getDaysCount());
                    int stepsCount = input.readStepsCount();
                    calendar.setStepsCount(month, day, stepsCount);
                    break;
                }
                case 3: {
                    int month = input.readMonth(calendar.getMonthCount());
                    calendar.printStatistics(month);
                    break;
                }
                case 4:
                    isRuning = false;
                    break;
                default:
                    System.out.printf("Недопустимая команда допустимые значения %s%n", menu.getAvailableOptions());
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

        }
    }
}
