package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        LogParser logParser = new LogParser(Paths.get("C:\\temp\\parser1.log"));
       // logParser.getNumberOfUniqueIPs( formatter.parse("05.01.2019 20:22:55"), formatter.parse("05.01.2038 20:22:55"));
        System.out.println(logParser.getNumberOfUniqueIPs( null, formatter.parse("05.01.2038 20:22:55")));
        System.out.println(logParser.getNumberOfUniqueIPs( formatter.parse("05.01.2019 20:22:55"), null));
        System.out.println(logParser.getNumberOfUniqueIPs( formatter.parse("05.01.2019 20:22:55"), formatter.parse("05.01.2038 20:22:55")));
        System.out.println(logParser.getNumberOfUniqueIPs( null, null));
        //System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
    }
}