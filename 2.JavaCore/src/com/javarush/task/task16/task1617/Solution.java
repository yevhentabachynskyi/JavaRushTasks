package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
      Thread thread = new Thread(clock);
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try{
            while (countSeconds>0){
                System.out.print(countSeconds+" ");
                Thread.sleep(1000);
                countSeconds--;
            }
            System.out.println("Марш!");
            } catch (InterruptedException e) {
                System.out.println("Прервано!");
            }


      /*          Thread current = RacingClock.currentThread();
                while (!current.isInterrupted()){
                    try {

                if (countSeconds == 3) {
                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                    System.out.print("Марш!");

                } else if (countSeconds == 4) {
                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                    System.out.print(countSeconds + " ");
                    countSeconds--;
                    Thread.sleep(1000);

                    System.out.println("Прервано!");
                }

                } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
        }
    }
}