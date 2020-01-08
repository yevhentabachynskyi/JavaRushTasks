package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task15.task1525.Statics.FILE_NAME;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        System.out.println(lines);

    }
    static {
   /*     try {
            FileReader reader = new FileReader(FILE_NAME);
            System.out.println(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        try {
        BufferedReader reader = new BufferedReader(new FileReader((FILE_NAME)));
        String line;

            while ((line = reader.readLine()) != null) {
                    lines.add(line);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
