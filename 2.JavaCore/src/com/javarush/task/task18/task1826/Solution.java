package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        int i = 0;

            if (args[0].equals("-e")) {
                FileInputStream inputStream = new FileInputStream(args[1]);
                FileOutputStream outputStream = new FileOutputStream(args[2]);
                if (inputStream.available() > 0){
                    byte[] byt = new byte[inputStream.available()];
                    inputStream.read(byt);
                for (byte b : byt) {
                    b = (byte) (b ^ 12);
                    byt[i++] = b;
                }
                outputStream.write(byt);
                    inputStream.close();
                    outputStream.close();
            }

        }

            if (args[0].equals("-d")) {

                FileInputStream inputStream = new FileInputStream(args[1]);
                FileOutputStream outputStream = new FileOutputStream(args[2]);
                if (inputStream.available() > 0) {
                    byte[] byt2 = new byte[inputStream.available()];
                    inputStream.read(byt2);
                for (byte b : byt2) {
                    b = (byte) (b ^ 12);
                    byt2[i++] = b;
                }
                outputStream.write(byt2);
                    inputStream.close();
                    outputStream.close();
            }
        }


    }

}
/*
if (args[0].equals("-e")||args[0].equals("-d")) {
        FileInputStream inputStream = new FileInputStream(args[1]);
        FileOutputStream outputStream = new FileOutputStream(args[2]);
        if (inputStream.available() > 0){
        byte[] byt = new byte[inputStream.available()];
        inputStream.read(byt);
        for (byte b : byt) {
        b = (byte) (b ^ 12);
        byt[i++] = b;
        }
        outputStream.write(byt);
        inputStream.close();
        outputStream.close();
        }

        }*/
