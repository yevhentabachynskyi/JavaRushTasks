package com.javarush.task.task22.task2205;

/* 
МНЕ нравится курс JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(String.format(getFormattedString(), "JavaRush", "курс", "мне", "нравится"));
        //должен быть вывод
        //"МНЕ нравится курс JavaRush"
    }
    public static String getFormattedString() {
        return "%3$S %4$s %2$1s %1$1s";
    }
}
