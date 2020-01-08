package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.*;
public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws IOException, InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);

    }

    public static void systemOutPrintln(String fileName) throws InterruptedException, IOException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private String fullFileName;
        private String fileContent = "";

        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;

        }
        public String getFileContent() {
            return fileContent;
        }
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File(this.fullFileName)))){
                String str;
                while ((str=reader.readLine())!=null){
                    fileContent+=str+" ";
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Error");
            }

        }
    }
}
       /*
C:\Documents and Settings\XPMUser\Desktop\Text1.txt
C:\Documents and Settings\XPMUser\Desktop\Text2.txt
       */