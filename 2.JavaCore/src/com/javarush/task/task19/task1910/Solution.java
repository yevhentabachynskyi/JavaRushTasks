package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(f1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(f2));
        String line;
        //List<String> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
         /*   char[] CharArray = line.toCharArray();
            //String[] s = line.split("[^., !?;:-]");
            for (char c: CharArray)
            if (!(c=='^'||c=='.'||c==','||c=='/'||c=='!'||c=='?'||c==';'||c==':'||c=='-'||c=='('||c==')'||c=='"'))*/
            String s = "[\\p{Punct}]";
            String result = line.replaceAll(s,"");
            bufferedWriter.write(result);
        /*    Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(line);
            while (m.find()){
                String result = m.group().replaceAll(s,"");
                System.out.println(result);}*/
                //bufferedWriter.write(result);

           // String l = line.replaceAll("[\\p{Punct}+[^()]]");


        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
