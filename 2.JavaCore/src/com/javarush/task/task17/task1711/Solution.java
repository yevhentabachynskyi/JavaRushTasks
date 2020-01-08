package com.javarush.task.task17.task1711;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.text.*;
import java.text.ParseException;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name;
        Sex sex;
        Date bd;
        Person p;
        int id;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i= 0; i < args.length; i++) {
            switch (args[0]) {

                case "-c":
                    synchronized (allPeople) {
                        name = args[i];
                        sex = (args[i+1] == "м") ? Sex.MALE : Sex.FEMALE;
                        bd = format.parse(args[i+2]);
                        if (sex == Sex.MALE) {
                            p = Person.createMale(name, bd);
                        } else {
                            p = Person.createFemale(name, bd);
                        }
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                    }


                case "-u":
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[i]);
                        name = args[i+1];
                        sex = (args[i+2] == "м") ? Sex.MALE : Sex.FEMALE;
                        bd = format.parse(args[i+3]);
                        p = allPeople.get(id);
                        p.setName(name);
                        p.setSex(sex);
                        p.setBirthDay(bd);
                    }

                case "-d":
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[1]);
                        p = allPeople.get(id);
                        p.setSex(null);
                        p.setBirthDay(null);
                        p.setName(null);
                    }

                case "-i":
                    synchronized (allPeople) {
                        id = Integer.parseInt(args[1]);
                        p = allPeople.get(id);
                        String sx = (p.getSex() == Sex.MALE) ? "м" : "ж";
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        System.out.println(p.getName() + " " + sx + " " + sdf.format(p.getBirthDay()));
                    }
                    break;
            }
        }

    }
}
