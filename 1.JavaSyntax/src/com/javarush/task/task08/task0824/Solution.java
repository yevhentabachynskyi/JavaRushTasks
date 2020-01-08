package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код


        Human igor = new Human("Igor",true,10);
        Human vasya = new Human("Vasya",true,9);
        Human petya = new Human("Petya",true,11);


        Human vitya = new Human("Vitya",true,30,petya,vasya,igor);
        Human lesya = new Human("Lesya",false,29,petya,vasya,igor);



        Human ivan = new Human("Ivan",true,50,lesya);
        Human lilia = new Human("Lilia",false,62,lesya);



        Human orest = new Human("Orest",true,51,vitya);
        Human olya = new Human("Olya",false,49,vitya);




        //System.out.println(children);
        System.out.println(ivan);
        System.out.println(lilia);
        System.out.println(orest);
        System.out.println(olya);
        System.out.println(vitya);
        System.out.println(lesya);
        System.out.println(petya);
        System.out.println(vasya);
        System.out.println(igor);

    }

    public static class Human  {

        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        //ArrayList<Human> children;
        ArrayList<Human> children = new ArrayList<Human>();

   /*     public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;

        }   VAR ARGS*/

        public Human(String name, boolean sex, int age, Human ... children ) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            for(Human x : children)
                this.children.add(x);

        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
