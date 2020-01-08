package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length > 0) {
            FileInputStream inputStream = new FileInputStream(args[0]);
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            int value = 1;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (map.containsKey(data)) {
                    value = map.get(data);
                value++;
                map.put(data, value);
            } else
            map.put(data, value);
            value = 1;
            }
            inputStream.close();
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                int key = pair.getKey();
                char k = (char) key;
                Integer val = pair.getValue();
                System.out.println(k + " " + val);
            }

        }
    }
}
