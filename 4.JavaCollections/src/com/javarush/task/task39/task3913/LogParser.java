package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class LogParser implements IPQuery {
    private Path logDir;
    SimpleDateFormat formatter=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }
  //  /* Парсер файлу построчно */
    public List parser() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(logDir.toFile()));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Date testDate;
        List<String> list = new ArrayList();
        List<String> result = new ArrayList<>();
        List<String> r = new ArrayList<>();
        try {
            list.addAll(parser());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings;
        for (String s: list){
            strings = s.split("\t");
       /*     for (String str: strings)
                System.out.println(str+"*");*/

            try {
                testDate =  formatter.parse(strings[2]);
                if (after != null && before != null) {
                    if ((testDate==before || testDate==after)||(testDate.after(after) && testDate.before(before)) && (after != null && before != null)) {
                        result.add(strings[0]);
                    }
                }/*else if(after == null && before == null) {
                    result.add(strings[0]);
                }*/

                if ( before!=null && after==null && testDate.before(before) || testDate==before){
                    result.add(strings[0]);
                } else if(after!=null && testDate.after(after) && before == null || testDate==after){
                    result.add(strings[0]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ;

        }
        for(String s: result) {
         if (Collections.frequency(result,s)==1){
               r.add(s);
            }
        }
        //r.forEach(s-> System.out.println(s));
        return r.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Date testDate;
        List<String> list = new ArrayList();
        Set<String> result = new HashSet<>();
        try {
            list.addAll(parser());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strings;
        for (String s: list){
            strings = s.split(" ");

            try {
                testDate =  formatter.parse(strings[4]+" "+strings[5]);
                if (after != null && before != null) {
                    if ((testDate.after(after) && testDate.before(before)) && (after != null && before != null)) {
                        result.add(strings[0]);
                    }
                }else if(after == null && before == null) {
                    result.add(strings[0]);
                }

                if ( before!=null && after==null && testDate.before(before)){
                    result.add(strings[0]);
                } else if(after!=null && testDate.after(after) && before == null){
                    result.add(strings[0]);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            ;

        }
        result.forEach(s-> System.out.println(s));
        return result;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}