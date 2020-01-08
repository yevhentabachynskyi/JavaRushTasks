package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.IOException;
import java.io.*;

public class AdapterFileOutputStream implements AmigoStringWriter{

    public static void main(String[] args) {

    }

    private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream){
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
    this.fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
    this.fileOutputStream.close();
    }
}

