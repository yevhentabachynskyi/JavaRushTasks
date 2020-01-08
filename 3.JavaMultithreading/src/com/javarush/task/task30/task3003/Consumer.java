package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by XPMUser on 1/31/19.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {

        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                ShareItem item = queue.take();
                System.out.format("Processing %s", item.toString());
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
