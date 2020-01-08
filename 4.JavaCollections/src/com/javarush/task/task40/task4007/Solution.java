package com.javarush.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датами
*/

public class Solution {
    final static String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm:ss";
    final static String DATE_FORMAT = "dd.MM.yyyy";
    final static String TIME_FORMAT = "HH:mm:ss";

    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static boolean isDateValid(String date, DateFormat d) {
        try {
            d.setLenient(true);
            d.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        DateFormat dtf = new SimpleDateFormat(DATE_TIME_FORMAT);
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        DateFormat tf = new SimpleDateFormat(TIME_FORMAT);
        if (isDateValid(date,dtf)){
            try {
                Date dat = dtf.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dat);
                System.out.println("День: " + calendar.get(Calendar.DATE));
                System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));
                System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
       else
        if (isDateValid(date,df)){
            try {
                Date dat = df.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dat);
                System.out.println("День: " + calendar.get(Calendar.DATE));
                System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7 : calendar.get(Calendar.DAY_OF_WEEK) - 1));
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
      else
        if (isDateValid(date,tf)){
            try {
                Date dat = tf.parse(date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dat);
                System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

}

