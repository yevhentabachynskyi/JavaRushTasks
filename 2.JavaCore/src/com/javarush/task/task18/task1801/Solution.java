package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<Integer>();
        reader.close();
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            list.add(data);
        }
        int j=0;
     for (int i = 0; i < list.size(); i++)
         if (list.get(j)< list.get(i)) j=i;
        inputStream.close();
            System.out.println(list.get(j));

    }
}
