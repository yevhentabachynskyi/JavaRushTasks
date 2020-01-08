package com.javarush.task.task32.task3213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        String s = "";
        if (reader!=null) {
            BufferedReader br = new BufferedReader(reader);
            String msg;
            while ((msg = br.readLine()) != null) {
                for (int x = 0; x < msg.length(); x++) {
                    char c = (char) (msg.charAt(x) + key);
                    if (c > 'z')
                        s += (char) (msg.charAt(x) - (26 - key));
                    else
                        s += (char) (msg.charAt(x) + key);
                }
            }
            br.close();

        }
            if (s!=null)
            return s;
        else
            return "";
    }
}
