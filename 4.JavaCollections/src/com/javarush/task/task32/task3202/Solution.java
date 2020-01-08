package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        try {

            int i;
            while ((i = is.read()) != -1) {
                writer.write(i);
            }
            is.close();
            writer.close();
            return writer;
        }catch (NullPointerException e){
            System.out.println(e);
        }
        if (writer!=null)
            return writer;
        else
            throw new NullPointerException();
    }
}