package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;
import java.util.List;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(f1);
        try (BufferedReader breader = new BufferedReader(fileReader);
        ) {
            String line;
            int count = 0;

            while ((line = breader.readLine()) != null) {
                String[] s = line.split("[., !?;:-]");
                for (String elem : s)
                {
                    if ("world".equals(elem))
                        count++;
                }
            }

            breader.close();
        fileReader.close();
            System.out.print(count);
    }
}
}

// C:\Documents and Settings\XPMUser\Desktop\1.txt