package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        reader.close();
        while (inputStream.available() > 0){
            int data = inputStream.read();
            list.add(data);
        }
        inputStream.close();
/*
        Integer am;
        for (Integer i : list) {
            am = hm.get(i);
            hm.put(i, (am == 0 ? 1 : am + 1));
            min = Collections.min(hm.values());
            for (Map.Entry<Integer, Integer> pair : hm.entrySet()) {
                if (pair.getValue() == min) {
                    System.out.print(pair.getValue() + " "); }
           }
        }*/
        int mix = 1;
        for (int i = 0; i < list.size(); i++){
            int count = Collections.frequency(list,list.get(i));
            //max = (count > max) ? count : max;
            if(count==mix){
                System.out.print(list.get(i)+" ");
                list.remove(i);
            }
        }
    }
}
//        C:\\text1.txt