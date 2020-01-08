package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/



import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
/*           BufferedReader reader = new BufferedReader(new FileReader("C:\\1.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\2.txt"));*/
        /*BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        String line;

        while((line = reader.readLine()) != null){
            String[] s = line.split("\\s");
            StringBuilder builder = new StringBuilder();
            for (String str: s){
                if (str.length() > 6 ){
                    builder.append(str).append(",");
                }
            }
              String completedString = builder.toString();
            if(completedString.endsWith(",")) {
                completedString = completedString.substring(0, completedString.length() - 1);
            }
            writer.write(completedString);
        }

        reader.close();
        writer.close();

*/
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        StringBuilder sb = new StringBuilder();
        while(fileReader.ready())
            sb.append(fileReader.readLine()).append(" ");
        fileReader.close();
        String content = sb.toString();
        sb.setLength(0);
        for(String s:content.split(" +"))
            if(s.length()>6)
                sb.append(s).append(",");
        sb.setLength(sb.length()-1);
        content=sb.toString();
        BufferedWriter writer=new BufferedWriter(new FileWriter(args[1]));
        writer.write(content);
        writer.close();
    }
}
