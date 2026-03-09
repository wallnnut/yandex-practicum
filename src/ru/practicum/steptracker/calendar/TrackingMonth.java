package ru.practicum.steptracker.calendar;

import java.time.*;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TrackingMonth {
    private String monthName;
    private int daysCount;
    private final List<TrackingDay> days = new ArrayList<>();

    public TrackingMonth(int monthNumber, boolean leapYear) {
        this.monthName = Month.of(monthNumber).getDisplayName(TextStyle.FULL_STANDALONE, Locale.of("ru", "RU"));
        this.daysCount = Month.of(monthNumber).length(leapYear);

        for (int i = 1; i <= daysCount; i++) {
            days.add(new TrackingDay(i));
        }
    }

    public TrackingMonth(int monthNumber) {
        this(monthNumber, false);
    }

    public int bestSeries(int aimStepsCount) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (TrackingDay day : days) {
            if (day.getSteps() >= aimStepsCount) {
                currentSeries += 1;

                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }

            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

    public TrackingDay getDay(int index) {
        return days.get(index - 1);
    }

    public String getMonthName() {
        return monthName;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void viewAllSteps() {
        System.out.printf("%4s%s%n", "    ", monthName);
        for (TrackingDay day : days) {
            System.out.printf("%-23s",
                    String.format("День %d: - %d шага/шагов%2s%n", day.getDayOfMonth(), day.getSteps(), "  "));
        }
        System.out.println();
    }

    public double avereageStepsCount() {
        double totalSteps = getTotalStepsCount();
        return totalSteps / daysCount;
    }

    public int findMaxStepsCount() {
        int max = 0;
        for (TrackingDay day : days) {
            int stepsCount = day.getSteps();
            if (stepsCount > max) {
                max = stepsCount;
            }
        }
        return max;
    }

    public int getTotalStepsCount() {
        int result = 0;
        for (TrackingDay day : days) {
            int stepsCount = day.getSteps();
            result += stepsCount;
        }
        return result;
    }
}
