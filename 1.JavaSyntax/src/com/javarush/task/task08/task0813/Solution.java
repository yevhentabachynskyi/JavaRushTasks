package com.javarush.task.task08.task0813;

import java.util.Set;
import java.util.HashSet;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        //напишите тут ваш код
        HashSet set = new HashSet();
        String L = "Л";
        for (int i=0; i<20; i++){
            set.add(L+i);
        }
        return set;

    }

    public static void main(String[] args) {
        //System.out.println(createSet());

    }
}
