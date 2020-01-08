package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string==null || !string.contains("\t")) {
            throw  new TooShortStringException();
        }
        String mynewstring = null;
                String str = string.substring(0,1);
        if (str.equals("\t")){
        String[] s = string.split("\t");
        if (s.length <= 2) {
            throw  new TooShortStringException();
        }
        StringBuffer result = new StringBuffer();
        result.append(s[0] + s[1]);
     mynewstring = result.toString();
        }
        else if (!str.equals("\t")){
            String[] s = string.split("\t");
            if (s.length <= 2) {
                throw  new TooShortStringException();
            }
            StringBuffer result = new StringBuffer();
            result.append(s[1]);
            mynewstring = result.toString();
        }


        return mynewstring;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - "));

    }
}
