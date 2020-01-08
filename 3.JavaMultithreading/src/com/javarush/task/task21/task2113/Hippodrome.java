package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.*;

public class Hippodrome {
    private static List<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game ;

    public List<Horse> getHorses(){
        return horses;
    }
    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (int i = 0; i < horses.size(); i++)
            horses.get(i).move();
    }
    public void print(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        return horses.stream().max(Comparator.comparingDouble(Horse::getDistance)).get();
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        Horse a = new Horse("A", 3, 0);
        Horse b = new Horse("B", 3, 0);
        Horse c = new Horse("C", 3, 0);
        horses.add(a);
        horses.add(b);
        horses.add(c);
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
