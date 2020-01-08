package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();
        try (BufferedReader breader = new BufferedReader(new FileReader(new File(f)))) {
            String line;
            while ((line = breader.readLine()) != null) {
                //...
                String[] s = line.split(" ");
                StringBuilder result = getLine(s);
                System.out.println(result);
            }
        }
        catch (IOException e) {
            System.err.println(e);
        }

    }
   // C:\2.txt
    public static StringBuilder getLine(String... words) {
        StringBuilder builder = new StringBuilder();

        if(words == null || words.length == 0) return new StringBuilder();

    /*        List<String> list = new ArrayList<>();
        for (String s : words) {
            list.add(s);
        }
        Collections.sort(list);

        for (int j = 0; j < list.size(); j++) {
            for (int i = j + 1; i < list.size(); i++) {
                if (list.get(j).toLowerCase().charAt(list.get(j).length() - 1) == list.get(i).toLowerCase().charAt(0)) {
                    String s = list.get(j + 1);
                    list.set(j + 1, list.get(i));
                    list.set(i, s);
                }
            }
        }
        for (String str : list)
            builder.append(String.format("%s ", str));


     builder.replace(builder.length() - 1, builder.length(), "");*/

        List<String> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String s : words) {
            temp.add(s);
        }


            return builder;

    }
}

