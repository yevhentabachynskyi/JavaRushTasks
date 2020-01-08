package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException,IOException{
       super(fileName);
         //   int a = fileName.length()-1;
//  if (){
        /*char cha = fileName.charAt(a);
        int b = fileName.length()-2;
        char chb = fileName.charAt(b);
        int c = fileName.length()-3;
        char chc = fileName.charAt(c);
        if (fileName.contains(".txt") && cha == 't' && chb == 'x' && chc == 't'){*/
    //super.close();

        if (!fileName.endsWith(".txt")) {
            super.close();
            throw new UnsupportedFileNameException();
        }





    }


    public static void main(String[] args) {
    }
}

