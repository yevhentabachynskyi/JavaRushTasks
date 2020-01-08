/*
package com.javarush.task.task19.task1920;

*/
/*
Самый богатый
*//*



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        Map<String, Double> map = new TreeMap<String, Double>();
        List<String> list = new ArrayList();
        String line;
        double value;
        while ((line = fReader.readLine()) != null) {
            String[] rec = line.split(" ");
            value = Double.parseDouble(rec[1]);
            if (map.containsKey(rec[0])) {
                map.put(rec[0], map.get(rec[0]) + value);
            } else {
                map.put(rec[0], value);
            }
        }
        fReader.close();

        double maxValueInMap = (Collections.max(map.values()));

        for (Map.Entry<String, Double> pairs : map.entrySet()) {
            if (pairs.getValue() == maxValueInMap) {
                list.add(pairs.getKey());
            }
        }
                Collections.sort(list);
                for (String s: list )
                System.out.println(s);
            }
        }



*/
