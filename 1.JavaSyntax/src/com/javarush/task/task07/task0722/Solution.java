package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList();

        //list.add(reader.readLine());
        String str = "end";

        while (true) {
            String string = reader.readLine();
            if (string.equals(str))
                break;
            list.add(string);
            //напишите тут ваш код

        }
        for (int j = 0; j < list.size(); j++)
            System.out.println(list.get(j));
    }
}
