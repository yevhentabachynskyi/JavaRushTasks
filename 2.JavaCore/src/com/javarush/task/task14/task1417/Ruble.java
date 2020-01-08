package com.javarush.task.task14.task1417;

/**
 * Created by XPMUser on 3/2/18.
 */
public class Ruble extends Money {
    public Ruble(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return 2.2;
    }

    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
