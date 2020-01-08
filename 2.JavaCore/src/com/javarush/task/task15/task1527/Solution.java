package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String str1 = url.substring(url.indexOf('?') + 1);
        String[] str = str1.split("&");
        String[] st = null;
        for (String s : str) {
            st = s.split("=");
            System.out.print(st[0] + " ");
        }
        System.out.println();
        for (String s : str) {
            st = s.split("=");
            boolean result = true;
            if (st[0].equals("obj") && result == st[1].matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                double d = Double.parseDouble(st[1]);
                alert(d);
            } else if (st[0].equals("obj") && result != st[1].matches("((-|\\+)?[0-9]+(\\.[0-9]+)?)+")) {
                String l = String.valueOf(st[1]);
                alert(l);
            }
        }
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
