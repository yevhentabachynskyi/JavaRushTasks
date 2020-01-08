package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Уникальные подстроки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s=="" || s.isEmpty())
            return 0;
        else {
            List<String> stringList = new ArrayList<>();
            String buffer = "";
            while (s.length() > 0)
                for (int i = 0; i < s.length(); i++) {
                    if (!buffer.contains(String.valueOf(s.charAt(i)))) {
                        buffer += s.charAt(i);
                    } else if (buffer.contains(String.valueOf(s.charAt(i)))) {
                        stringList.add(buffer);
                        s = s.replaceFirst(buffer, "");
                        buffer = "";
                    }


                }
            int m = stringList.get(0).length();
            for (String str : stringList)
                if (str.length() > m)
                    m = str.length();
            return m;
        }
    }
}
