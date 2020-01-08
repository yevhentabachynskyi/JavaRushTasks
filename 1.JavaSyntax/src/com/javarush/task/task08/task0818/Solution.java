package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> hm= new HashMap<String, Integer>();

        hm.put("qwe", 500);
        hm.put("qweasd", 100);
        hm.put("sd", 150);
        hm.put("asd", 600);
        hm.put("zxc", 250);
        hm.put("qwwe", 360);
        hm.put("fda", 120);
        hm.put("gda", 800);
        hm.put("hda", 320);
        hm.put("jda", 170);

        return hm;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> keyList = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            int count = 0;
            Integer many;
            String currentKey = null;
            Integer temp = 0;
            Boolean chek = false;
            for (Map.Entry<String, Integer> pair : map.entrySet()) {
                currentKey = pair.getKey();
                if (!keyList.isEmpty()) {
                    if (keyList.contains(currentKey)) continue;
                    chek = false;
                }
                many = pair.getValue();
                if (!chek) {
                    temp = many;
                    chek = true;
                }
                if (many.equals(temp) & chek) count++;
            }
            if (count == 0) break;
            else if (count == 1) keyList.add(currentKey);
            else {
                HashMap<String, Integer> copy = new HashMap<String, Integer>(map);
                for (Map.Entry<String, Integer> pair : copy.entrySet()) {
                    if (pair.getValue() < 500)
                        map.remove(pair.getKey());

                }
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map=createMap();
        removeItemFromMap(map);
         //System.out.println(map);
    }
}