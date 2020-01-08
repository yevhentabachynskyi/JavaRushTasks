package com.javarush.task.task15.task1522;

/**
 * Created by XPMUser on 3/12/18.
 */
public class Sun implements Planet{


    private Sun() {
    }
    private static Sun instance;
    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }

        return instance;
    }
}
