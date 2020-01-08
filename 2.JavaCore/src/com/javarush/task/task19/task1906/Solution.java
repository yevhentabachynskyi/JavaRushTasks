package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        FileReader freader = new FileReader(f1);
        FileWriter fwriter = new FileWriter(f2);
        List list = new ArrayList<>();
        while (freader.ready()){
            int data = freader.read();
            list.add(data);}
            for (int i = 0; i < list.size(); i++){
            if (!(i%2==0))
            fwriter.write((Integer) list.get(i));}

        freader.close();
        fwriter.close();
    }
}

/*

C:\Documents and Settings\XPMUser\Desktop\Text1.txt
C:\Documents and Settings\XPMUser\Desktop\Text2.txt
        */
