package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new FileWriter(br.readLine())))
        {
            // чтение построчно
            String text;
            while(!(text=br.readLine()).equals("exit")) {
                bw.write(text + "\r\n");
            }
            bw.write("exit");
            bw.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
