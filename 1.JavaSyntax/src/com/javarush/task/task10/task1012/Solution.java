package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        String x = list.toString();
        char[] listchar = x.toCharArray();
        for (int j = 0; j < abcArray.length; j++) {
            //char q=abcArray[j];
            //System.out.println(q + " " + x.codePoints().filter(ch->ch==q).count());
            int cnt = 0;
            for (int i = 0; i < listchar.length; i++)
                if (listchar[i] == abcArray[j]) cnt++;
            System.out.println(abcArray[j] + " " + cnt);
        }
    }}



