package com.javarush.task.task14.task1421;

/**
 * Created by taye on 05.03.2018.
 */
class Singleton {
    private static Singleton instance;

    private Singleton(Singleton instance) {
    }

    public static Singleton getInstance(){
        Singleton singleton = new Singleton(instance);
            return instance;
    }
}
