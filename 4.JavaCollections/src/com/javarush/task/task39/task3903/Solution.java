 package com.javarush.task.task39.task3903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

 /*
 Неравноценный обмен
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Please enter a number: ");

        long number = Long.parseLong(reader.readLine());
        System.out.println("Please enter the first index: ");
        int i = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second index: ");
        int j = Integer.parseInt(reader.readLine());

        System.out.println("The result of swapping bits is " + swapBits(number, i, j));
    }

    public static long swapBits(long number, int i, int j) {
        String bin_str = Long.toBinaryString(number);
        while (bin_str.length()<8)
            bin_str = "0"+bin_str;

        String[] strings = bin_str.split("");
        for (int k = strings.length; k >=0; k--)
            if (k == i){
                String temp = strings[i];
                strings[i] = strings[j];
                strings[j] = temp;
            }
        number = Long.parseLong(String.join("", strings),2);
        return number;
    }
}
