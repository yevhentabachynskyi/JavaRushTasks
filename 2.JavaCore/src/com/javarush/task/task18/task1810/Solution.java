package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;



public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream ;

  /*      int count = 0;
        if (inputStream.available() > 0) {
            byte[] bytes = new byte[inputStream.available()];
           count = inputStream.read(bytes);}*/

       while ((inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())).available() >= 1000);
                inputStream.close();
                throw new DownloadException();




    }

    public static class DownloadException extends Exception {


    }
}
//    C:\Documents and Settings\XPMUser\Desktop\1.txt