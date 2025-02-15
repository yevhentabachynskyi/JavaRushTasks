package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string==null) {
            throw  new TooShortStringException();
        }
        String[] s = string.split(" ");
        if (s.length < 5) {
            throw  new TooShortStringException();
        }
        StringBuffer result = new StringBuffer();
        result.append(s[1] + " " + s[2] + " " + s[3] + " " + s[4]);
        String mynewstring = result.toString();

        return mynewstring;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
