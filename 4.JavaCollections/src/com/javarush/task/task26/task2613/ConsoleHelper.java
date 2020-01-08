package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    // вивід повідомлення в консоль
    public static void writeMessage(String message){
        System.out.println(message);
    }
    //читання з консолі
    public static String readString() throws IOException {
        return bis.readLine();
    }
    //зчитування коду валюти
    public static String askCurrencyCode() throws IOException {
        String code = null;
        writeMessage("Введіть код валюти:");
        while (true) {
            code = readString();
            if (code.length() == 3)
                break;
            else
                writeMessage("Error:");

        }
        return code.toUpperCase();
    }
    //зчитування номіналу і кількості банкнот
    public static String[] getValidTwoDigits(String currencyCode) throws IOException{
        String[] strings = null;
        System.out.println("Первое число - номинал, второе - количество банкнот");
        String s = readString();
        String[] str = s.split(" ");
        try
        { int nom = Integer.parseInt(str[0]);
                int number = Integer.parseInt(str[1]);
            if (nom>=0 && number>=0)
                return str;
        } catch (Exception e) {
            System.out.println("дані не коректні");
            getValidTwoDigits(currencyCode);
        }
        return str;
    }
    //отримати дані яку операцію виконати
    public static Operation askOperation() {
        int i = 0;
        Operation operation = null;
        while (true) {
            try {
                i = Integer.parseInt(readString());
                operation = Operation.getAllowableOperationByOrdinal(i);
                break;
            } catch (Exception e) {
                System.out.println("Помилка. Введіть дані повторно.");
            }
        }
        return operation;
    }
}
