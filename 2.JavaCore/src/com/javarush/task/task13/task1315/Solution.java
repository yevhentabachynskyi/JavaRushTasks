package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

public class Solution {
    public static void main(String[] args) {

    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    public class Dog implements Movable,Eat{

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }
    }
    public class Cat implements Movable, Eat, Eatable{

        @Override
        public void eat() {

        }

        @Override
        public void eaten() {

        }

        @Override
        public void move() {

        }
    }
    public class Mouse implements Movable, Eatable{
        @Override
        public void eaten() {

        }

        @Override
        public void move() {

        }
    }
}