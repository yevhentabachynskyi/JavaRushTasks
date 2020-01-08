package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();
        FileInputStream inputStream2 = new FileInputStream(f2);
        FileInputStream inputStream3 = new FileInputStream(f3);
        FileOutputStream outputStream = new FileOutputStream(f1);
        reader.close();

        if (inputStream2.available() > 0) {
            byte[] bytes2 = new byte[inputStream2.available()];
            outputStream.write(bytes2);
        }
        inputStream2.close();
        if (inputStream3.available() > 0) {
            byte[] bytes3 = new byte[inputStream3.available()];
            outputStream.write(bytes3);
        }

        inputStream3.close();
        outputStream.close();

    }
}
/*
C:\Documents and Settings\XPMUser\Desktop\1.txt
C:\Documents and Settings\XPMUser\Desktop\Text1.txt
C:\Documents and Settings\XPMUser\Desktop\Text2.txt
*/