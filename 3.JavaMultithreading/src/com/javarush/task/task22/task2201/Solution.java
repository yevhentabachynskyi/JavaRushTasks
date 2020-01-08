package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public synchronized String getPartOfString(String string, String threadName) throws Throwable
    {

        int first = string.indexOf('\t');
        int last = string.lastIndexOf('\t');

        String substr = null;

        try {
            substr = string.substring(first + 1, last);
        } catch (StringIndexOutOfBoundsException e) {
            switch (threadName) {
                case FIRST_THREAD_NAME:
                    TooShortStringFirstThreadException ex1 = new TooShortStringFirstThreadException();
                    ex1.initCause(e);
                    throw ex1;
                case SECOND_THREAD_NAME:
                    TooShortStringSecondThreadException ex2 = new TooShortStringSecondThreadException();
                    ex2.initCause(e);
                    throw ex2;
                default:
                    RuntimeException ex3 = new RuntimeException();
                    ex3.initCause(e);
                    throw ex3;
            }
        }

        return substr;
    }
}
