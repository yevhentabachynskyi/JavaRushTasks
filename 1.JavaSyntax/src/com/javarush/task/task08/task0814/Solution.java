package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;



/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        HashSet set = new HashSet(20);
        for (int i=0; i<20; i++){
            set.add(i);
        }
        return set;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Set<Integer> tmp = new HashSet<>();
        for(int temp : set){
            if(temp > 10){
                tmp.add(temp);
            }
        }
        set.removeAll(tmp);
        return set;
    }


    public static void main(String[] args) {
        //System.out.println(createSet());


    }
}
