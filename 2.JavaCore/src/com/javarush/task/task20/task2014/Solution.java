package com.javarush.task.task20.task2014;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

/*
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\11.txt");

        FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(file);

        Solution savedObject = new Solution(5);

        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(savedObject);

       // Solution loadedObject = new Solution(4);

        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Solution loadedObject = (Solution) ois.readObject();

        System.out.println( savedObject.string.equals(loadedObject.string));
        System.out.println(new Solution(4));

        inputStream.close();
        outputStream.close();
        oos.close();
        ois.close();

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
