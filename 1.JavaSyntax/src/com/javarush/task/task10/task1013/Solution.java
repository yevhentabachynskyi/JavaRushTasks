package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String firstname;
        private String lastname;
        private int age;
        private boolean sex;
        private String adress;
        private int many;

        public Human(String firstname,String lastname){
            this.firstname = firstname;
            this.lastname = lastname;
        }
        public Human(int age){
            this.age = age;
        }
        public Human(boolean sex){
            this.sex = sex;
        }
        public Human(String adress){
            this.adress = adress;
        }
        public Human(int age, boolean sex){
            this.age = age;
            this.sex = sex;

        }
        public Human(String firstname,String lastname,String adress){
            this.firstname = firstname;
            this.lastname = lastname;
            this.adress = adress;
        }
        public Human(String firstname,String lastname, boolean sex){
            this.firstname = firstname;
            this.lastname = lastname;
            this.sex = sex;

        }
        public Human(String firstname,String lastname,int many){
            this.firstname = firstname;
            this.lastname = lastname;
            this.many = many;

        }
        public Human(int many,int age){
            this.many = many;
            this.age = age;
        }
        public Human(){
        }


        // напишите тут ваши переменные и конструкторы
    }
}
