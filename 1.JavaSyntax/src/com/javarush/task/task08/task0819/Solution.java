package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    private  static  Cat cat1;
    private  static  Cat cat2;
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        cats.remove(cat1);
        //напишите тут ваш код. step 3 - пункт 3

        printCats(cats);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<Cat>();
        cat1=new Cat();
        cats.add(cat1);
        cat2=new Cat();
        cats.add(cat2);
        cats.add(new Cat());
        //напишите тут ваш код. step 2 - пункт 2
        return cats;
    }

    public static void printCats(Set<Cat> cats) {
        for (int i=0; i<cats.size(); i++)
        System.out.println((Cat)cats.toArray()[i]);
        // step 4 - пункт 4
    }
    public static class Cat{
    }
    // step 1 - пункт 1
}
