package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {
    Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = new Calendar();
    }

    @AfterEach
    void tearDown() {
        calendar = null;
    }

    @Test
    void initialize() {
        calendar.initialize();
        calendar.setCurrentMonth(Month.DECEMBER);
        calendar.setCurrentYear(2022);
        int expectedValue = 31;
        int actualValue = calendar.daysInMonth();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void daysInMonth() {
        calendar.initialize();
        calendar.setCurrentMonth(Month.FEBRUARY);
        calendar.setCurrentYear(2022);
        int expectedValue = 28;
        int actualValue = calendar.daysInMonth();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void startDay() {
        calendar.initialize();
        calendar.setCurrentMonth(Month.MAY);
        calendar.setCurrentYear(2022);
        int actualValue = calendar.startDay();
        assertTrue(0 <= actualValue && actualValue<= 6);
    }

    @Test
    void setCurrentYear() {
        calendar.initialize();
        calendar.setCurrentMonth(Month.DECEMBER);
        calendar.setCurrentYear(2022);
        int expectedValue = 31;
        int actualValue = calendar.daysInMonth();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void setCurrentMonth() {
        calendar.initialize();
        calendar.setCurrentMonth(Month.DECEMBER);
        calendar.setCurrentYear(2022);
        int expectedValue = 31;
        int actualValue = calendar.daysInMonth();
        assertEquals(expectedValue, actualValue);
    }
}