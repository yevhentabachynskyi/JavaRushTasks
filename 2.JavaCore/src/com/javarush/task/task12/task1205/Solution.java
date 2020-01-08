package com.javarush.task.task12.task1205;

/* 
Определимся с животным
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        Cow cow = new Cow();
        if(o instanceof Cow) return "Корова";
        Dog dog = new Dog();
        if(o instanceof Dog) return "Собака";
        Whale whale= new Whale();
        if(o instanceof Whale) return "Кит";
       /* Pig pig = new Pig();
        if(o instanceof Pig) */

            return "Неизвестное животное";
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
