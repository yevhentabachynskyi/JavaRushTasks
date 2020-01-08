package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by XPMUser on 10/11/18.
 */
public class Producer implements Runnable {
    private ConcurrentHashMap<String, String>  map;

    public Producer(ConcurrentHashMap<String, String>  map) {
        this.map = map;
    }

    @Override
    public void run() {
            try {
                int c = 0;
                    while (true) {
                        map.put(String.valueOf(++c), String.valueOf("Some text for " + c));
                        Thread.sleep(500);
                    }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+" thread was terminated" );
            }
        }
    }

