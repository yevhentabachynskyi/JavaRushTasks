package com.javarush.task.task18.task1823;


import java.io.*;
import java.util.*;


/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line=reader.readLine()).equals("exit")) {
            ReadThread readThread = new ReadThread(line);
            readThread.start();
        }

   for (Map.Entry<String, Integer> entry : resultMap.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

        reader.close();


    }

    public static class ReadThread extends Thread {
        public String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;

        }

        @Override
        public void run() {
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                List<Integer> list = new ArrayList<Integer>();
                while (inputStream.available() > 0)
                {
                    int data = inputStream.read();
                   list.add(data);


                }
                Map<Integer, Integer> couterMap = new HashMap<>();
                for (Integer i: list){
                    int count = Collections.frequency(list, i);
                    couterMap.put(i,count);
                }

                int maxValueInMap=(Collections.max(couterMap.values()));

                for (Map.Entry<Integer, Integer> entry : couterMap.entrySet()) {
                    if (entry.getValue() == maxValueInMap) {
                        //System.out.println(entry.getKey());
                        resultMap.put(fileName, entry.getKey());
                    }



                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут

    }
}
