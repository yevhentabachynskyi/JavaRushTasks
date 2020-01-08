package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enter a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("The entered number has " + result + "ones");

    }

    public static boolean isWeightEven(long number) {
        String bin_str = Long.toBinaryString(number); // 11
        int cont = 0;
        for (int i = 0; i < bin_str.length(); i++)
            if (bin_str.charAt(i)=='1')
                cont++;

            if (cont%2==0)
                return true;
            else
                return false;
    }
}
