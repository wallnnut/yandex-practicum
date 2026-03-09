package ru.practicum.steptracker.calendarinput;

import ru.practicum.common.input.UserInput;

import java.util.Scanner;

public class CalendarInput extends UserInput {
    private final Scanner scanner = new Scanner(System.in);

    public int readMonth(int monthCount) {
        System.out.println("Введите месяц");
        int month = readInt();
        if (month > monthCount || month <= 0) {
            throw new IllegalArgumentException("Неверный формат месяца доступные значения от 1 до 12");
        }
        return month;

    }

    public int readDay(int daysCount) {
        System.out.println("Введите день");
        int day = readInt();
        if (day > daysCount || day <= 0) {
            throw new IllegalArgumentException(
                    String.format("Неверный формат дня доступные значения от %d до %d ", 1, daysCount));
        }
        return day;
    }

    public int readStepsCount() {
        System.out.println("Введите количество шагов");
        int stepsCount = readInt();
        if (stepsCount <= 0) {
            throw new IllegalArgumentException("Количество шагов должно быть больше 0");
        }
        return stepsCount;

    }

}
