package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/
/*
public class Solution {

        //напишите тут ваш код
        public static void main(String[] args) throws Exception
        {

            ArrayList<String> list = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int f = 0;
            for (int i = 0; i < 10; i++){
                String s = reader.readLine();
                list.add(s);
            }
            int max = 0;//list.get(0).length();
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).length() > max) {
                    max = list.get(i).length();
                }
            }
            for (int j = 0; j < 10; j++) {

                if (max == list.get(j).length()) {
                    if (j>f)
                        f=j;

                }
                   // System.out.println(list.get(i));

            }
            int min = list.get(0).length();

            for (int i = 0; i < list.size()-1; i++)

                if (min > list.get(i + 1).length())

                    min = list.get(i + 1).length();

            for (int j = 0; j < 10; j++)

                if (min == list.get(j).length()) {
                    if (j<f)
                        f=j;
                }
                    System.out.println(list.get(f));



        }


        }
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = 0;
        int max = 0;
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(max).length() < list.get(i).length()) {
                max = i;
            }
            if (list.get(min).length() > list.get(i).length()) {
                min = i;
            }
        }
        if (max < min) {
            System.out.println(list.get(max));
        } else
            System.out.println(list.get(min));
    }
}