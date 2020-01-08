package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f2));
        while (bufferedReader.ready()){
            int i = bufferedReader.read();
            if (i == 46){
                i = 33;
                bufferedWriter.write(i);
            } else bufferedWriter.write(i);

        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
/*
C:\1.txt
C:\555.txt
*/
