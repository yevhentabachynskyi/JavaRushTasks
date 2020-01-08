package com.javarush.task.task16.task1632;

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Solution extends Thread{
    public static List<Thread> threads = new ArrayList<>(5);

    public static void main(String[] args) {

    }
    static {
        threads.add(new Thread_1());
        threads.add(new Thread_2());
        threads.add(new Thread_3());
        threads.add(new Thread_4());
        threads.add(new Thread_5());
    }
    public static class Thread_1 extends Thread {

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }}

        public static class Thread_2 extends Thread {

            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }

            }
        }}

        public static class Thread_3 extends Thread {
            public void run() {
                while (!isInterrupted()){
                    System.out.println("Ура");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        public static class Thread_4 extends Thread implements Message{
            private boolean isCancel = false;
            public void run() {
                while (!isCancel)
                {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }

            @Override
            public void showWarning() {
                this.isCancel = true;
            }
        }

        public static class Thread_5 extends Thread {

            public void run() {


                    int i = 0;
                    while(true){
                        Scanner scanner = new Scanner(System.in);
                        String s = scanner.nextLine();

                        if("N".equals(s)){
                            break;
                        }
                        else{
                            i = i + Integer.valueOf(s);
                        }
                    }System.out.println(i);

            }
        }
    }
