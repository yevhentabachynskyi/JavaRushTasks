package com.javarush.task.task29.task2909.human;


import java.util.*;

public class Human implements Alive{
    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;
    private int id;
    private int age;
    private String name;
    private BloodGroup bloodGroup;


    public class Size{
        public int height;
        public int weight;
    }
    Size size = new Size();

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human human){
        children.add(human);
    }
    public void removeChild(Human human){
        children.remove(human);
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public int getId() {
        return id;
    }


    public void printSize() {

        System.out.println("Рост: " +  size.height + " Вес: " + size.weight);
    }

    @Override
    public void live() {

    }
   public String getPosition(){
       return "Человек";
   }
    public void printData() {
        System.out.println( getPosition() + ": " + name);
    }
}