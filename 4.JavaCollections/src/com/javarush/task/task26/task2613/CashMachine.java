package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.command.DepositCommand;
import com.javarush.task.task26.task2613.command.InfoCommand;


import java.io.IOException;
import java.util.Locale;

public class CashMachine {
    public static void main(String[] args){
        Locale.setDefault(Locale.ENGLISH);
     /*   try {
            String currentCode = ConsoleHelper.askCurrencyCode();
            String[] strings = ConsoleHelper.getValidTwoDigits(currentCode);
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currentCode);
            currencyManipulator.addAmount(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            currencyManipulator.getTotalAmount();
        } catch (Exception e){}*/
        //CommandExecutor.execute(Operation.LOGIN);
        try {
            Operation operation;
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Good bye!");
        }
    }

}
