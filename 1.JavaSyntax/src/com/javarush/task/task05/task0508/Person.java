package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
*/

public class Person {
    //напишите тут ваш код
    String name;
    int age;
    char sex;
    public void setName(String name) { //сеттер
        this.name=name;
    }
    public String getName() { //геттер
        return this.name;
    }
    public void setAge(int age) { //сеттер
        this.age=age;
    }
    public int getAge() { //геттер
        return this.age;
    }

    public void setSex(char sex) { //сеттер
        this.sex=sex;
    }
    public char getSex() { //геттер
        return this.sex;
    }

    public static void main(String[] args) {

    }
}
