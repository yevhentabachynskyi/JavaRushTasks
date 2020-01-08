package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human Petro = new Human("Петро",true,55);
        Human Dmytro = new Human("Дмитро",true,56);
        Human Marina = new Human("Марина",false,68);
        Human Oksana = new Human("Оксана",false,10);
        Human Viktor = new Human("Віктор",true,30,Petro,Marina);
        Human Lilia = new Human("Лілія",false,20,Dmytro,Oksana);
        Human Vova = new Human("Петро",true,6,Viktor,Lilia);
        Human Galya = new Human("Галя",false,7,Viktor,Lilia);
        Human Olya = new Human("Оля",false,8,Viktor,Lilia);
        //System.out.print(Petro,Dmytro,Marina,Oksana,Viktor,Lilia,Vova,Galya,Olya);
        System.out.println(Petro);
        System.out.println(Dmytro);
        System.out.println(Marina);
        System.out.println(Oksana);
        System.out.println(Viktor);
        System.out.println(Lilia);
        System.out.println(Vova);
        System.out.println(Galya);
        System.out.println(Olya);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;

        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;



        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















