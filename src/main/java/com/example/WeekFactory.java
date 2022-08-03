package com.example;

public class WeekFactory {
    private final int maxNumber;
    private final int initialWeekDay;
    private int dayCount = 0;

    public WeekFactory(Calendar calendar) {
        this.maxNumber = calendar.daysOfMonth();
        this.initialWeekDay = calendar.startDay();
    }

    public String nextWeek() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int weekDay = 0; weekDay < 7; weekDay++) {
            if (dayCount == 0 && weekDay < initialWeekDay) {
                stringBuilder.append("     ");
            } else if (dayCount < maxNumber){
                dayCount++;
                stringBuilder.append(String.format("%5d", dayCount));
            }
        }
        return stringBuilder.toString();
    }
}
