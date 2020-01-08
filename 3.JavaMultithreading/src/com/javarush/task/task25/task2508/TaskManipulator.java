package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable,CustomThreadManipulator {

    private Thread thread;
    boolean aBoolean = true;


    @Override
    public void run() {
      // thread = Thread.currentThread();
        while (aBoolean) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                thread.interrupt();
            }

//            if (thread.isInterrupted())
//                break;
        }
    }

    @Override
    public void start(String threadName) {
       // if (thread.getName().equals(threadName))
        aBoolean=true;
        thread = new Thread(this,threadName);
        thread.start();
    }

    @Override
    public void stop() throws InterruptedException {
       if (thread.getState() == Thread.State.RUNNABLE)
        aBoolean = false;
      /*  if (thread.getState() == Thread.State.WAITING)
            thread.interrupt();*/
}
}
