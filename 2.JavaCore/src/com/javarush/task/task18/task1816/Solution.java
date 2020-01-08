package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        int count = 0;
        if (args.length > 0) {
            FileInputStream inputStream = new FileInputStream(args[0]);

            while (inputStream.available() > 0) {
                int i = inputStream.read();
                if ((i >= 97 && i <= 122) || (i >= 65 && i <= 90))
                    count++;
            }
            inputStream.close();

        }
        System.out.println(count);

        }

        }


