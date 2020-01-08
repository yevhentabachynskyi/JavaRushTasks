package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        try (BufferedReader breader = new BufferedReader(new FileReader(new File(file1)));
             BufferedWriter writer = new BufferedWriter(new FileWriter(new File(file2)))
        ) {

            String line;

            while ((line = breader.readLine()) != null) {
                String[] numbers = line.split(" ");

                for (String num : numbers) {
                    try {
                        long res = Math.round(Double.parseDouble(num));
                        writer.write(res + " ");
                    } catch (NumberFormatException e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}


      /*
       E:/data.txt
       E:/result.txt
       */