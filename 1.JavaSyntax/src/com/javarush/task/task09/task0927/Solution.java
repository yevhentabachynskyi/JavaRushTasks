package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();

        Cat murzik = new Cat("Murzik");
        map.put("Murzik",murzik);
        Cat murzi = new Cat("Murzi");
        map.put("Murzi",murzi);
        Cat murz = new Cat("Murz");
        map.put("Murz",murz);
        Cat mur = new Cat("Mur");
        map.put("Mur",mur);
        Cat mu = new Cat("Mu");
        map.put("Mu",mu);
        Cat m = new Cat("M");
        map.put("M",m);
        Cat urzik = new Cat("urzik");
        map.put("urzik",urzik);
        Cat rzik = new Cat("rzik");
        map.put("rzik",rzik);
        Cat zik = new Cat("zik");
        map.put("zik",zik);
        Cat ik = new Cat("ik");
        map.put("ik",ik);


        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> set = new HashSet<Cat>(map.values());
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
