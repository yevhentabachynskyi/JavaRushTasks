package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        //implement logic here, use the lock field
        if(lock.tryLock() == false)
            ifLockIsBusy();
        else if(lock.tryLock() == true) {
            try {
                ifLockIsFree();
            } catch (Exception e) {
                lock.unlock();
            }
        }

    }

    public void ifLockIsFree() {
    }

    public void ifLockIsBusy() {
    }
}
