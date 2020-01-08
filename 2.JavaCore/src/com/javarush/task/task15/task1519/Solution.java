package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input = reader.readLine()).equals("exit")) {
            try {
                if (input.contains(".")) {
                    print(Double.valueOf(input));
                    continue;
                }
                Integer integer = Integer.parseInt(input);
                if (integer <= 0 || integer >= 128) {
                    print(integer);
                    continue;

                }
                 if (Short.valueOf(input) > 0 && Short.valueOf(input) < 128) {
                        print(Short.valueOf(input));
                     continue;
                    }

            } catch (NumberFormatException e) {

            }

        print(input);
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
