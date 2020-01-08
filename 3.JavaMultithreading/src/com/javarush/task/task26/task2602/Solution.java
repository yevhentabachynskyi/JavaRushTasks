package com.javarush.task.task26.task2602;

import java.util.*;


/* 
Был бы ум - будет и успех
*/
public class Solution {
    public static void main(String[] args) {
        ArrayList<Soldier> soldiers = new ArrayList<Soldier>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        Collections.sort(soldiers);

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier>{
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }
        public int compareTo(Soldier o)
        {
            return o.height - this.height;
        }
    }
}
