package com.javarush.task.task29.task2913;

import java.util.ArrayList;
import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
   /*     if (a > b) {
            return a + " " + getAllNumbersBetween(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + getAllNumbersBetween(a + 1, b);
        }*/
        //System.out.println(a+"A"+"***"+b+"B");
        ArrayList<Integer>  list = new ArrayList();
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        if (a < b) {
            for (int i = a; i <= b; i++)
                list.add(i);
            for(Integer n: list)
                builder1.append(n + " ");
        }  else if (a > b){
            for (int i = a; i >= b; i--)
                list.add(i);
            for(Integer n: list)
                builder2.append(n + " ");

        }else   if (a == b) {
            return Integer.toString(a);
        }

            return builder1.toString().trim() + "\n" +  builder2.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(10);
        numberB = random.nextInt(100);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}