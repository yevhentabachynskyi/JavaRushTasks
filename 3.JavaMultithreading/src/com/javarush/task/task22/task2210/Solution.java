package com.javarush.task.task22.task2210;
import java.util.*;
/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            list.add(token);
        }
        String[] strings = list.stream().toArray(String[]::new);
        return strings;
    }
}
