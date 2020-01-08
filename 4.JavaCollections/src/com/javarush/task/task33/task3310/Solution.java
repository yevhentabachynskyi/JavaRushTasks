package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.FileStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.OurHashMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        HashSet<Long> longs = new HashSet<>();
        for (String s: strings)
           longs.add(shortener.getId(s));
        return longs;
    }
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        HashSet<String> strings = new HashSet<>();
        for (Long l: keys)
            strings.add(shortener.getString(l));
        return strings;
    }
    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Helper.printMessage(strategy.getClass().getSimpleName());
        HashSet<String> tempStringHashSet = new HashSet<>();
        for (int i=0; i<elementsNumber; i++){
            tempStringHashSet.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);
        getIds(shortener,tempStringHashSet);

        Set<Long> idsSet;
        Date startTime1 = new Date();
        idsSet = getIds(shortener, tempStringHashSet);
        Date finishTime1 = new Date();

        long msDelay1 = finishTime1.getTime() - startTime1.getTime();
        Helper.printMessage(Long.toString(msDelay1));

        Set<String> stringSet;
        Date startTime2 = new Date();
        stringSet = getStrings(shortener, idsSet);
        Date finishTime2 = new Date();

        long msDelay2 = finishTime2.getTime() - startTime2.getTime();
        Helper.printMessage(Long.toString(msDelay2));

        if (tempStringHashSet.equals(stringSet))
            Helper.printMessage("Тест пройден.");
        else  Helper.printMessage("Тест не пройден.");

    }
    public static void main(String[] args) {
        StorageStrategy storageStrategy = new HashMapStorageStrategy();
        testStrategy(storageStrategy,10000);
        StorageStrategy ourstorageStrategy = new OurHashMapStorageStrategy();
        testStrategy(ourstorageStrategy,10000);
        StorageStrategy filestorageStrategy = new FileStorageStrategy();
        testStrategy(filestorageStrategy,100);

    }
}
