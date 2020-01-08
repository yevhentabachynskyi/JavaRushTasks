package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i<=36; i++) {
            try {
                Integer.toString(Integer.parseInt("12AS08Z"), i);
                list.add(i);
            }catch(NumberFormatException e){
                System.out.println("incorrect");
            }
        }
        Integer min = Collections.min(list);
        System.out.println(min);
    }
}