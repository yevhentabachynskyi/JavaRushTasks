package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        FileReader fileReader  = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine())!=null){
        Pattern p = Pattern.compile("<"+args[0]+"?[[[a-zA-Z_0-9][ \\t\\n\\x0B\\f\\r]][^>]]+>|</"+args[0]+">");
        Matcher m = p.matcher(line);
        while(m.find()) {
            System.out.print(line.substring(m.start(), m.end()));
        }}

        fileReader.close();
        bufferedReader.close();

    }
}
