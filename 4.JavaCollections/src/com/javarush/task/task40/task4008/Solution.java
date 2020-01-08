package com.javarush.task.task40.task4008;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с Java 8 DateTime API
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
                /*Date dat = dtf.parse(date);

                LocalDate localDate = dat.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalTime localTime = dat.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();*/
                String[] splt = date.split(" ");
                String sdate = splt[0];
                String stime = splt[1];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
                DateTimeFormatter formattert = DateTimeFormatter.ofPattern("H:m:s");
                LocalDate localDate = LocalDate.parse(sdate,formatter);
                LocalTime localTime = LocalTime.parse(stime,formattert);

                System.out.println("День: " + localDate.getDayOfMonth());
                System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
                System.out.println("День месяца: " + localDate.getDayOfMonth());
                System.out.println("День года: " + localDate.getDayOfYear());
                System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
                System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
                System.out.println("Месяц: " + localDate.getMonthValue());
                System.out.println("Год: " + localDate.getYear());
                System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
                System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
                System.out.println("Часы дня: " + localTime.getHour());
                System.out.println("Минуты: " + localTime.getMinute());
                System.out.println("Секунды: " + localTime.getSecond());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        if (isDateValid(date,df)){
            try {
                LocalDate localDate;

                DateTimeFormatter formatter;
                    formatter = DateTimeFormatter.ofPattern("d.M.yyyy");
                   localDate = LocalDate.parse(date,formatter);

                System.out.println("День: " + localDate.getDayOfMonth());
                System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
                System.out.println("День месяца: " + localDate.getDayOfMonth());
                System.out.println("День года: " + localDate.getDayOfYear());
                System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
                System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
                System.out.println("Месяц: " + localDate.getMonthValue());
                System.out.println("Год: " + localDate.getYear());

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        else
        if (isDateValid(date,tf)){
            try {
               /* Date dat = tf.parse(date);

                LocalTime localTime = dat.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();*/
                DateTimeFormatter formattert = DateTimeFormatter.ofPattern("H:m:s");
                LocalTime localTime = LocalTime.parse(date,formattert);

                System.out.println("AM или PM: " + (localTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
                System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
                System.out.println("Часы дня: " + localTime.getHour());
                System.out.println("Минуты: " + localTime.getMinute());
                System.out.println("Секунды: " + localTime.getSecond());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
