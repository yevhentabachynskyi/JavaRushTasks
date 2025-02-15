package com.javarush.task.task30.task3004;



import java.util.concurrent.RecursiveTask;

/**
 * Created by XPMUser on 2/1/19.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;
    static  int num = Runtime.getRuntime().availableProcessors();
    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask task = new BinaryRepresentationTask(b);
            task.fork();
            return task.join() + result;
        }
        return result;
      }
    }

