package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by XPMUser on 1/31/19.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int N=1; N<=9; N++){
            queue.offer(new ShareItem("ShareItem-N", N));
            System.out.format("Элемент 'ShareItem-%d' добавлен",N);
            System.out.println();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.hasWaitingConsumer()){
                System.out.format("Consumer в ожидании!");
                System.out.println();
            }
        }
    }
}
