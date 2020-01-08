package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/
import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    public static void main(String[] args) {

    }
    public FileConsoleWriter(File file) throws IOException {
       this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter  = new FileWriter(file, append);

    }
    public FileConsoleWriter(FileDescriptor fd){
        this.fileWriter  = new FileWriter(fd);

    }
    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter  = new FileWriter(fileName);

    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);

    }


    public void write(char[] cbuf, int off, int len) throws IOException{
        this.fileWriter.write(cbuf, off, len);
        for(int i=off;i<off+len;i++) System.out.print(cbuf[i]);
    }
    public void write(int c) throws IOException{
        this.fileWriter.write(c);
        System.out.println(c);
    }
    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off+len));
    }
    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.println(cbuf);
    }
    public void close() throws IOException {
        this.fileWriter.close();
    }

}
