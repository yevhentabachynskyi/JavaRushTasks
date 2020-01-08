package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String number = "0123456789";
        List<Byte> list = new ArrayList<>();
        while (list.size()<8) {
            list.add(ABC.getBytes()[(int)(Math.random()*ABC.getBytes().length)]);
            list.add(abc.getBytes()[(int)(Math.random()*abc.getBytes().length)]);
            list.add(number.getBytes()[(int)(Math.random()*number.getBytes().length)]);
        }
        list.remove((int)Math.random()*8);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        for (int i: list)
        outputStream.write(i);;
        return outputStream;
    }
}