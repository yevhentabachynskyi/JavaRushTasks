package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {  //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {

            while (true) {

                list.add(Integer.parseInt(reader.readLine()));
            }


        } catch (NumberFormatException e) {
        for (Object i : list) {
            if (i instanceof Integer) {
                System.out.println(i);
            } else if (i instanceof String){
                for(int j=0; j<list.size(); j++)
                    System.out.println(list.get((j-1)));
            }
        }



    } catch (IOException e) {
        for (Object i : list) {
            if (i instanceof Integer) {
                System.out.println(i);
            } else if (i instanceof String){
                for(int j=0; j<list.size(); j++)
                    System.out.println(list.get((j-1)));
            }
        }


    }
    }}
