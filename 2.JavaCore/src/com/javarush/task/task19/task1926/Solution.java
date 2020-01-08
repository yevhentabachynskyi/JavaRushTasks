package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.length() > 0) {
                reverseString(line, line.length() - 1);
            }

        }
        bufferedReader.close();
    }

    public static void reverseString(String s, int index) {
        if (index == 0) {
            System.out.println(s.charAt(index));
            return;
        }
        System.out.print(s.charAt(index));
        reverseString(s, index - 1);
    }
}

//C:\5.txt