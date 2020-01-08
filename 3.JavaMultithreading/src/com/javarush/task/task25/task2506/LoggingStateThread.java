package com.javarush.task.task25.task2506;

/**
 * Created by XPMUser on 9/24/18.
 */
public class LoggingStateThread extends Thread{
   private State state;
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        state = target.getState();
    }

    public void run(){
        System.out.println(state);

        while(true){
            if (target.getState() != state) {
                state = target.getState();
                System.out.println(state);
            }
          if (target.getState() == State.TERMINATED){
                break;
            }
        }
    }

}

