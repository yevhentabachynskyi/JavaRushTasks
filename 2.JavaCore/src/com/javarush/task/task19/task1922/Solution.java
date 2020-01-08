package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();


    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));
        String line;
       while ((line = bufferedReader.readLine()) != null) {
           String[] s = line.split(" ");
           int count = 0;
           for (String str1: words){
               for (String str2: s)
               if (str2.equals(str1))
                   count++;}
           if (count == 2)
               System.out.println(line);


       }

        bufferedReader.close();
    }
}


//     C:\5.txt