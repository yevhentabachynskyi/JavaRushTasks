package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.io.IOException;

public class DepositCommand implements Command {
    @Override
    public void execute() {
        String currentCode = "";
        String[] strings = new String[0];
        try {
            currentCode = ConsoleHelper.askCurrencyCode();
            strings = ConsoleHelper.getValidTwoDigits(currentCode);
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currentCode);
            currencyManipulator.addAmount(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        } catch (IOException e) {
            execute();
        }

    }
}
