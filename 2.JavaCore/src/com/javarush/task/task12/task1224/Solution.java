package com.javarush.task.task12.task1224;

/* 
Неведома зверушка
*/

import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
       Object cat = new Cat();
        if (o instanceof Cat )
        {
            return "Кот";
        }
        Object tiger = new Tiger();
        if (o instanceof Tiger)
        {
            return "Тигр";
        }
        Object Lion = new Lion();
        if (o instanceof Lion )
        {
            return "Лев";
        }
        Object bull = new Bull();
        if (o instanceof Bull )
        {
            return "Бык";
        }
      /*  Object pig = new Pig();
        if (o instanceof Pig ) {
            return "Бык";
        }*/


            return "Животное";
    }

    public static class Cat {
    }

    public static class Tiger {
    }

    public static class Lion {
    }

    public static class Bull {
    }

    public static class Pig {
    }
}
