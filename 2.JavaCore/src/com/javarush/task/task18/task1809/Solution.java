package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        reader.close();
        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] bytes = new byte[inputStream.available()];
            int count = inputStream.read(bytes);
            for (int i = 0; i < count / 2; i++) {
                byte tmp = bytes[i];
                bytes[i] = bytes[bytes.length - i - 1];
                bytes[bytes.length - i - 1] = tmp;
            }
            outputStream.write(bytes);


        }
        inputStream.close();
        outputStream.close();
    }
}
