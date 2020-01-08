package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() throws InterruptedException {
        while (value == 0){
            this.wait();
      }
        isValuePresent = false;
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        while (value == 0)
        this.notifyAll();
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
    }
}
