package com.javarush.task.task08.task0827;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("MAY 2 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date(date)); можно и без форматирования даты
        calendar.setTime(format.parse(date)); // с SimpleDateFormat более универсальное решение
        return calendar.get(Calendar.DAY_OF_YEAR) % 2 != 0;
    }
}
/*
    Date curDate = new Date(date);
    Date zeroDate = new Date(date);
zeroDate.setMonth(0);
        zeroDate.setDate(0);
        return ((curDate.getTime() - zeroDate.getTime()) / 86400000) %2 != 0;*/
