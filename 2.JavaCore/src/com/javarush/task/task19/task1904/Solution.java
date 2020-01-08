package com.javarush.task.task19.task1904;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.text.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("C:\\6.txt"));
        PersonScanner adapter = new PersonScannerAdapter(s);
        System.out.println(adapter.read());
        adapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private  Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner= fileScanner;
        }

        @Override
        public Person read() {
            if (fileScanner.hasNext()) {
                String[] inputArray = fileScanner.nextLine().split(" ");
                Date birthDate = (new GregorianCalendar(Integer.parseInt(inputArray[5]),
                        Integer.parseInt(inputArray[4]) - 1, Integer.parseInt(inputArray[3]))).getTime();
                return new Person(inputArray[1], inputArray[2], inputArray[0], birthDate);
            }
            return null;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}