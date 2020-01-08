package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(b);
        if (x <= 0 || y <= 0) throw new Exception();

        System.out.println(gcd(x,y));
    }
    public static int gcd(int x,int y)  {

            while (y != 0) {
                int tmp = x % y;
                x = y;
                y = tmp;
            }


        return x;
    }
    }

