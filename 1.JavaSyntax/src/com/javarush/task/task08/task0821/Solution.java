package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String,String> map = new HashMap<String, String>();
        map.put("qwe", "Igor");
        map.put("qwe", "Oleg");
        map.put("sd", "Oleg");
        map.put("asd", "Petr");
        map.put("zxc", "Petr");
        map.put("qwwe", "Igor");
        map.put("fda", "Semen");
        map.put("gda", "Semen");
        map.put("hda", "Semen");
        map.put("jda", "Semen");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
