package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.io.IOException;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        String currentCode = null;

         /*   currentCode = ConsoleHelper.askCurrencyCode();
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currentCode);*/

            for (CurrencyManipulator currencyManipulator: CurrencyManipulatorFactory.getAllCurrencyManipulators()) {
                try {
                if (!currencyManipulator.hasMoney())
                    ConsoleHelper.writeMessage("No money available.");
                else
                    ConsoleHelper.writeMessage(currentCode + "-" + currencyManipulator.getTotalAmount());
            } catch(Exception e){
                e.printStackTrace();
            }

        }

    }
}
