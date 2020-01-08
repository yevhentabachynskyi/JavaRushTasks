package com.javarush.task.task14.task1417;

/**
 * Created by XPMUser on 3/2/18.
 */
public class Hrivna extends Money {
    public Hrivna(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return 0.1;
    }

    @Override
    public String getCurrencyName() {
        return "HRN";
    }
}
