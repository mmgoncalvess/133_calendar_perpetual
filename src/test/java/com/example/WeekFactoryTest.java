package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekFactoryTest {
    WeekFactory weekFactory;
    Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = new Calendar();
    }

    @AfterEach
    void tearDown() {
        weekFactory = null;
        calendar = null;
    }

    @Test
    void nextWeek() {
        calendar.setCurrentYear(2022);
        calendar.setCurrentMonth(Month.JUNE);
        weekFactory = new WeekFactory(calendar);
        String stringOne = weekFactory.nextWeek();
        stringOne = stringOne.trim();
        assertTrue(stringOne.length() > 0);
        for (int i = 0; i < 5; i++) {
            weekFactory.nextWeek();
        }
        String stringTwo = weekFactory.nextWeek();
        stringTwo = stringTwo.trim();
        assertTrue(stringTwo.length() == 0);
    }
}