package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        BufferedReader breader = new BufferedReader(new FileReader(f1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        String line;
        while ((line = breader.readLine()) != null) {
    Pattern pat=Pattern.compile("(((\\s)|^)(\\d+)((\\s)|$))");
            Matcher matcher = pat.matcher(line);
            while (matcher.find()) {
                //System.out.print(matcher.group(1).trim() + " ");
             writer.write(matcher.group(1).trim() + " ");
            }
           // writer.write(matcher.group());
            }
        breader.close();
        writer.close();
        }

    }

/*
C:\Documents and Settings\XPMUser\Desktop\Text1.txt
C:\Documents and Settings\XPMUser\Desktop\Text2.txt
*/

