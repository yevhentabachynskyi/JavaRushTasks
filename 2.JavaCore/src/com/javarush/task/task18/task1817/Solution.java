package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        double p1 = 0;
        double p2 = 0;
        double s = 0;
        if (args.length > 0) {
            FileInputStream inputStream = new FileInputStream(args[0]);

            if (inputStream.available() > 0) {
                byte[] bytes = new byte[inputStream.available()];
                p1 = bytes.length;
            }
                while (inputStream.available() > 0) {
                int i = inputStream.read();
                if (i==32)
                    p2++;
            }
            inputStream.close();
        s = p2/p1*100;
          //  String.format("%.2g%n", s);


        }
        double d = (double)Math.round(s * 100d) / 100d;
        System.out.println(d);

    }
}
