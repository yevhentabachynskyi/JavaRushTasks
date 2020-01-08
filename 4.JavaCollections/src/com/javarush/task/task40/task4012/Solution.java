package com.javarush.task.task40.task4012;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isLeap(LocalDate date) {
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) {
        LocalDateTime date = LocalDateTime.now();
        return dateTime.isBefore(date);
    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
        return chronoUnit.addTo(time,n);
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate.isBefore(secondDate))
            return  Period.between(firstDate,secondDate);
        else
        return  Period.between(secondDate,firstDate);
    }
}
