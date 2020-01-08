package com.javarush.task.task27.task2712.ad;

/**
 * Created by XPMUser on 1/24/19.
 */
public class Advertisement {
    private Object content;
    private  String name;
    private long initialAmount;
    private   int hits;
    private  int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount/hits;
    }


    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying(){
        amountPerOneDisplaying = hits > 0 ? initialAmount / hits : 0;
    return amountPerOneDisplaying;
    }

    public void revalidate(){
        if (hits <= 0){
            throw new UnsupportedOperationException();
        } else
            hits--;
    }
}
