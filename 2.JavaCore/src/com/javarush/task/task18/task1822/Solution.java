package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        reader.close();
        try (BufferedReader breader = new BufferedReader(new FileReader(new File(f1)));
        ) {
            String line;

            while ((line = breader.readLine()) != null) {
                String[] numbers = line.split(" ");
                for (String num: numbers) {
                       if (num.equals(args[0]))
                           System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
