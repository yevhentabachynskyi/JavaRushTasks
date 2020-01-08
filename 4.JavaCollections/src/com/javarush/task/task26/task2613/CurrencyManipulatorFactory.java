package com.javarush.task.task26.task2613;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    //якщо map не мість ключ currencyCode то створюєм новий обєкт CurrencyManipulator і додаємо в map а якщо мість то повертаємо існуючий
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        map.forEach((k, v) -> {
                    if (!k.equalsIgnoreCase(currencyCode))
                        map.put(currencyCode, new CurrencyManipulator(currencyCode));

                }
        );
        return map.get(currencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
            return map.values();
    }
}
