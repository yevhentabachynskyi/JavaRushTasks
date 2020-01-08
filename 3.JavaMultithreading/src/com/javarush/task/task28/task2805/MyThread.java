package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by XPMUser on 12/20/18.
 */
public class MyThread extends Thread{
 static volatile  AtomicInteger atomicInteger = new AtomicInteger();

    public MyThread() {
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }

    public MyThread(Runnable target) {
        super(target);
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }

    public MyThread(String name) {
        super(name);
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        this.setPriority((atomicInteger.get()<10)?atomicInteger.addAndGet(1):atomicInteger.addAndGet(-9));
    }
}
