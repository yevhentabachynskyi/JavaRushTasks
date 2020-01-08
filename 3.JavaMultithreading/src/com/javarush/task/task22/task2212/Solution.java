 package com.javarush.task.task22.task2212;
 import java.util.regex.*;
/* 
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber != null) {
            String regex = "^((0|\\+38)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(telNumber);

            if (matcher.matches() && telNumber.length() >= 10) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234561"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("050123-4567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));

    }
}
