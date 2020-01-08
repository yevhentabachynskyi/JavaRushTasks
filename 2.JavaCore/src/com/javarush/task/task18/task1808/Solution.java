package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream stream1 = new FileOutputStream(file2);
        FileOutputStream stream2 = new FileOutputStream(file3);

        reader.close();
      /*  int count1 = 0;
        int count2 = 0;
        byte[] buffer = new byte[inputStream.available()];
       byte[] buffer1 = new byte[buffer.length/2];
        byte[] buffer2 = new byte[buffer.length/2];
       if (inputStream.available() > 0) {

           // int count = inputStream.read(buffer);
           for (int i = 0; i < buffer.length; i++)
               if (i <= buffer.length / 2) {
                   buffer1[i] = buffer[i];
                   count1 = inputStream.read(buffer1);
               } else if (i > buffer.length / 2) {
                   buffer2[i] = buffer[i];
                   count2 = inputStream.read(buffer2);
               }
       }*/
        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] bytes = new byte[inputStream.available()];
            int count = inputStream.read(bytes);
            int half = count / 2;
            stream1.write(bytes, 0, half);
            stream2.write(bytes, count - half, half);
          /*  stream1.write(bytes, 0, count - count / 2);
            stream2.write(bytes, count - count / 2, count - (count - count / 2));*/

        }

           inputStream.close();
           stream1.close();
           stream2.close();



    }
}
      /*
C:\Documents and Settings\XPMUser\Desktop\1.txt
C:\Documents and Settings\XPMUser\Desktop\Text1.txt
C:\Documents and Settings\XPMUser\Desktop\Text2.txt
*/