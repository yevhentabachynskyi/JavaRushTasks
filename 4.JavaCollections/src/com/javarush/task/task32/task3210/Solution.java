package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws Exception {
        String text = args[2];
        long number = Integer.parseInt(args[1]);
        RandomAccessFile raf = new RandomAccessFile(args[0], "rw");
        raf.seek(number);
        byte[] b = new byte[text.length()];
        raf.read(b, 0, b.length);
        String result =  new String(b);
        System.out.println(result);
        raf.seek(raf.length());
        if (text.equals(result)) {
            raf.write("true".getBytes());
        }
        else {
            raf.write("false".getBytes());
        }
        raf.close();

    }

}
