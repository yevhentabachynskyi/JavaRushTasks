package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        int x = 0;
        while (true) {
            int number = Integer.parseInt(reader.readLine());
            x++;
            if (number == -1) {
                break;
            }
            sum += number;
        }
        System.out.println(sum / (x - 1));
    }
}

