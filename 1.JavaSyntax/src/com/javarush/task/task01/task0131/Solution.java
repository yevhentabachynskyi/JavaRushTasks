package com.javarush.task.task01.task0131;

/* 
Полнометражная картина
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getMetreFromCentimetre(243));
    }

    public static int getMetreFromCentimetre(int centimetre) {
        //напишите тут ваш код
        int Met = centimetre/100;
        return Met;
    }
}