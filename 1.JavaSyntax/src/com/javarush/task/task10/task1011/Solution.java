package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/


public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        System.out.println(s);
        for (int i = 0; i<39; i++)
            System.out.println(removeCharAt(s,i));
    }
    public static String removeCharAt(String st, int pos) {
        return st.substring(pos+1);

    }
}




