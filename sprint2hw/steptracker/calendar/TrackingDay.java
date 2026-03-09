package ru.practicum.steptracker.calendar;

class TrackingDay {
    private int steps = 0;
    private int dayOfMonth;

    public TrackingDay(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getSteps() {
        return steps;
    }

}