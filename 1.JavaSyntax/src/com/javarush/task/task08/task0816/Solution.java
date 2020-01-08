package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Map.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("January 1 1980"));
        map.put("Сильвестр", new Date("January 1 1980"));
        map.put("Вандамм", new Date("January 1 1980"));
        map.put("Кинконг", new Date("January 3 1980"));
        map.put("Брюсли", new Date("January 1 1980"));
        map.put("Чакнорис", new Date("January 1 1980"));
        map.put("Чичолинна", new Date("January 1 1980"));
        map.put("Мордем", new Date("August 1 1980"));
        map.put("Юсбих", new Date("JUNE 1 1980"));
        map.put("Модем", new Date("July 1 1980"));
        return map;
    }
        //напишите тут ваш код


    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        int countMonth = 0;

        for(Entry<String, Date> entry : map.entrySet()){
            Integer month=entry.getValue().getMonth();
            if(month==5 || month==6 || month==7) countMonth++;
        }

        for(int i=0; i<countMonth; i++){
            for (Entry<String, Date> entry : map.entrySet()) {
                Integer month=entry.getValue().getMonth();

                if(month==5 || month==6 || month==7) {
                    //System.out.println(month);
                    map.remove(entry.getKey());
                    break;
                }

            }
        }

    }

    public static void main(String[] args) {
        //System.out.println(createMap());
    }
}
