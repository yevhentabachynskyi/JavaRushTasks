package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach a = new Beach("A",9,100);
        Beach b = new Beach("B",10,80);
        System.out.println(a.compareTo(b));

    }

    @Override
    public synchronized int compareTo(Beach o) {
       /* Beach a = new Beach("A",5,50);
        Beach b = new Beach("B",4,80);*/
    /*    int result = 0;
        if(!(this.getName().equals(o.getName()))  && this.getDistance() < o.getDistance() && this.getQuality() > o.getQuality()) {
            return ++result;
        } else if(!(this.getName().equals(o.getName()))   && this.getDistance() > o.getDistance() && this.getQuality() < o.getQuality()) {
            return --result;
        }else if (this.getName().equals(o.getName()) && this.getDistance() == o.getDistance() && this.getQuality() == o.getQuality()){
            return result;}

            return result;*/
        float result = this.quality - this.distance - o.quality + o.distance;
        return (int) result;
    }
}
