package com.javarush.task.task20.task2003;


import java.io.*;
import java.util.*;

/* 
Знакомство с propertie
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    FileInputStream fileinputStream;

    public  void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        fileinputStream = new FileInputStream(fileName);
        load(fileinputStream);

    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String, String> entry : properties.entrySet())
        prop.setProperty(entry.getKey(),entry.getValue());
        prop.store(outputStream,"");
        outputStream.close();

        }

    public  void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        for (final String name: prop.stringPropertyNames())
            properties.put(name, prop.getProperty(name));
        inputStream.close();

    }

    public static void main(String[] args) throws Exception {
/*        fillInPropertiesMap();
        load(fileinputStream);
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());}*/
    }
}
