package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Move {
        public void move();
    }

    public interface Eat {
        public void eat();
    }

    public class Dog implements Move,Eat{

        @Override
        public void eat() {

        }

        @Override
        public void move() {

        }
    }

    public class Duck implements Fly,Eat,Move{
        @Override
        public void eat() {

        }

        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }
    }

    public class Car implements Move{
        @Override
        public void move() {

        }
    }

    public class Airplane implements Move,Fly{
        @Override
        public void fly() {

        }

        @Override
        public void move() {

        }
    }
}
