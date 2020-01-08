package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        FileInputStream in = new FileInputStream(f);
        FileOutputStream out1 = new FileOutputStream(f);
        FileInputStream in2 = new FileInputStream(f2);
        FileOutputStream out2 = new FileOutputStream(f,true);
        while (in2.available() > 0) {
            out1.write(in2.read());
        }
        in2.close();
        while (in.available() > 0) {
            out2.write(in.read());
        }

        in.close();
        out1.close();
        out2.close();


    }
}
/*
C:\Documents and Settings\XPMUser\Desktop\Text1.txt
C:\Documents and Settings\XPMUser\Desktop\Text2.txt
*/
