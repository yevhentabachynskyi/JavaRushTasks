package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws Exception {
        String text = args[2];
        long number = Integer.parseInt(args[1]);
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        raf.seek(number);
        byte[] byteArray = text.getBytes();
        if ((raf.length()-number)>=text.length())
            raf.write(byteArray);
        else{
            raf.seek(raf.length());
            raf.write(byteArray);
        }
        raf.close();
    }
}
