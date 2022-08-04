package com.example;

import java.util.HashSet;
import java.util.Set;

public class Calendar {
    private int currentYear;
    private Month currentMonth;
    private final Set<Month> monthsWith30Days = new HashSet<>();

    public Calendar() {
        initialize();
    }

    public void initialize() {
        monthsWith30Days.add(Month.APRIL);
        monthsWith30Days.add(Month.JUNE);
        monthsWith30Days.add(Month.SEPTEMBER);
        monthsWith30Days.add(Month.NOVEMBER);
    }

    public int daysInMonth() {
        return getNumberOfDaysInMonth(currentMonth);
    }

    public int startDay() {     //  0:Sunday - 6:Saturday
        int FIRST_DAY_OF_YEAR_0001 = 1;
        return (getTotalNumberOfDays() + FIRST_DAY_OF_YEAR_0001) % 7;
    }

    private int getNumberOfDaysInMonth(Month month) {
        if (monthsWith30Days.contains(month)) return 30;
        if (month.equals(Month.FEBRUARY)) return isLeapYear(currentYear)? 29 : 28;
        return 31;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    private int getTotalNumberOfDays() {
        int days = 0;
        for(int i = 1; i < currentYear; i++) days += isLeapYear(i)? 366 : 365;
        for(int j = 1; j < indexOfMonth(currentMonth); j++) days += getNumberOfDaysInMonth(nameOfMonth(j));
        return days;
    }

    private int indexOfMonth(Month monthName) {
        return monthName.ordinal() + 1;
    }

    private Month nameOfMonth(int index) {
        Month[] arrayOfMonths = Month.values();
        return arrayOfMonths[index-1];
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public void setCurrentMonth(Month currentMonth) {
        this.currentMonth = currentMonth;
    }
}
