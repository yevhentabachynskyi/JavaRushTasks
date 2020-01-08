package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> hm= new HashMap<String, String>();

        hm.put("qwe", "Igor");
        hm.put("qweasd", "Igor");
        hm.put("sd", "Oleg");
        hm.put("asd", "Petr");
        hm.put("zxc", "Petr");
        hm.put("qwwe", "Igor");
        hm.put("fda", "Semen");
        hm.put("gda", "Semen");
        hm.put("hda", "Semen");
        hm.put("jda", "Semen");

        return hm;

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        {
            ArrayList<String> keyList = new ArrayList<String>();
            for (int i = 0; i < 15; i++) {
                int count = 0;
                String currentName;
                String currentKey = null;
                String tempName = "";
                Boolean chek = false;
                for (Map.Entry<String, String> pair : map.entrySet()) {
                    currentKey = pair.getKey();
                    if (!keyList.isEmpty()) {
                        if (keyList.contains(currentKey)) continue;
                        chek = false;
                    }
                    currentName = pair.getValue();
                    if (!chek) {
                        tempName = currentName;
                        chek = true;
                    }
                    if (currentName.equals(tempName) & chek) count++;
                }
                if (count == 0) break;
                else if (count == 1) keyList.add(currentKey);
                else {
                    removeItemFromMapByValue(map, tempName);
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map=createMap();
        removeTheFirstNameDuplicates(map);
       // System.out.println(map);
    }
}
