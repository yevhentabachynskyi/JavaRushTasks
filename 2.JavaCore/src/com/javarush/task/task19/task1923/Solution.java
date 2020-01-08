package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException{
      /*  BufferedReader reader = new BufferedReader(new FileReader("C:\\1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\2.txt"));*/
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;
        while((line = reader.readLine()) != null){

            String regex1 = "\\S*\\d+\\S*";
            //String regex2 = "[0-9]+";
            String[] s = line.split(" ");
            for (int i = 0; i < s.length; i++){
               if (s[i].matches(regex1)){
                  System.out.println(s[i]);
                   writer.write(s[i]+" ");}
            }

        }
        reader.close();
        writer.close();
    }

}
