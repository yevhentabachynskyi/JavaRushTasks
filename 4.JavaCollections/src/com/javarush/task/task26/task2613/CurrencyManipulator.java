package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public String getCurrencyCode() {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    // додаємо в map якщо ключ номінал вже існує то кількість збільшуємо +1 а якщо ні то додаємо новий номінал і кількість
    public void addAmount(int denomination, int count){
        if (denominations.containsKey(denomination)){
            count++;
            denominations.put(denomination,count);
        } else
        denominations.put(denomination,count);

    }
    public  int getTotalAmount() throws Exception{
        //CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(ConsoleHelper.askCurrencyCode());
        int result = 0;
        for (Map.Entry<Integer,Integer> entry: denominations.entrySet()){
            result += entry.getKey()*entry.getValue();
        }
        return result;
    }
    public boolean hasMoney(){
        if (denominations.isEmpty())
        return false;
        else return true;
    }
}
