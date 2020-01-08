package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

            if (list.get(0).length() > list.get(1).length())

                System.out.println(1);

            else if (list.get(1).length() > list.get(2).length())

                System.out.println(2);
            else if (list.get(2).length() > list.get(3).length())

                System.out.println(3);
            else if (list.get(3).length() > list.get(4).length())

                System.out.println(4);
            else if (list.get(4).length() > list.get(5).length())

                System.out.println(5);
            else if (list.get(5).length() > list.get(6).length())

                System.out.println(6);
            else if (list.get(6).length() > list.get(7).length())

                System.out.println(7);
            else if (list.get(7).length() > list.get(8).length())

                System.out.println(8);
            else if (list.get(8).length() > list.get(9).length())

                System.out.println(9);

            else
                return;
        }
    }
