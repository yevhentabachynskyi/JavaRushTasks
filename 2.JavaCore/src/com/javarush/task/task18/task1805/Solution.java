package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
      List<Integer> list = new ArrayList<Integer>();
        //Set<Integer> list = new HashSet<Integer>() {};

        reader.close();
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            list.add(data);
        }
        inputStream.close();
        Collections.sort(list);
       /* Set<Integer> set = new HashSet<Integer>() {};
        set.addAll(list);*/
        Set<Integer> set = new LinkedHashSet<>(list);
        for (Integer i: set)
        System.out.print(i + " ");
    }
}
