package ru.practicum.steptracker.calendar;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import ru.practicum.steptracker.converter.Converter;

public class TrackingCalendar {
    private static final int MONTH_COUNT = 12;
    private final List<TrackingMonth> monthList = new ArrayList<>();
    private final Converter converter = new Converter();
    private int aimStepsCount = 10_000;

    public TrackingCalendar(int year) {
        boolean isLeapYear = Year.of(year).isLeap();

        for (int i = 1; i <= MONTH_COUNT; i++) {
            TrackingMonth month = new TrackingMonth(i, isLeapYear);
            monthList.add(month);
        }
    }

    public TrackingCalendar() {
        this(Year.now().getValue());
    }

    public TrackingMonth getMonth(int index) {
        return monthList.get(index - 1);
    }

    public void setStepsCount(int month, int day, int stepsCount) {
        getMonth(month).getDay(day).setSteps(stepsCount);

    }

    public int getMonthCount() {
        return MONTH_COUNT;
    }

    public void setAimStepsCount(int aimStepsCount) {
        this.aimStepsCount = aimStepsCount;
    }

    public void printStatistics(int index) {
        TrackingMonth month = getMonth(index);
        month.viewAllSteps();
        int totalSteps = month.getTotalStepsCount();
        int series = month.bestSeries(aimStepsCount);
        int maxSteps = month.findMaxStepsCount();
        double avereageStepsCount = month.avereageStepsCount();

        System.out.printf("Общее количество шагов - %d%n", totalSteps);
        System.out.printf("Максимальное пройденное количество шагов - %d%n", maxSteps);
        System.out.printf("Среднее количество шагов - %.2f%n", avereageStepsCount);
        System.out.printf("Пройденная дистанция - %s%n", converter.convertStepsToKm(totalSteps));
        System.out.printf("Количество сожжённых килокалорий - %s%n", converter.calculateCalories(totalSteps));
        System.out.printf("Лучшая серия - %d%n", series);
        System.out.println();
    }

}
