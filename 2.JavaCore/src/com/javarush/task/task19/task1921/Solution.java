package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.text.*;


/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
           BufferedReader reader = new BufferedReader(new FileReader(args[0] /*"C:\\4.txt"*/));
           String line;
           List<String> list1 = new ArrayList<>();
           List<String> list2 = new ArrayList<>();
           Date date = null;
        String name;
        String data;
           while ((line = reader.readLine()) != null) {
               name = line.replaceAll("[0-9]", "").trim();
               data = line.replaceAll("[^0-9 ]", "");
                DateFormat format = new SimpleDateFormat("dd MM yyyy");
                       date = format.parse(data);
               PEOPLE.add(new Person(name, date));

           }
             /*  String[] s = line.split(" ");
               StringBuilder builder = new StringBuilder(list1.size());
               StringBuilder builder2 = new StringBuilder(list2.size());
               for (int i = 0; i < s.length; i++) {
                   if (s[i].matches("[0-9]?\\d+"))
                       list1.add(s[i]);
                   else if (!(s[i].matches("[0-9]?\\d+")))
                       list2.add(s[i]);
                   for (String num : list1) {
                       builder.append(num + " ");
                   }
                   list1.remove(s[i]);
                   for (String str : list2) {
                       builder2.append(str + " ");
                   }
                   list2.remove(s[i]);
               }
               DateFormat format = new SimpleDateFormat("dd MM yyyy"*//*, Locale.ENGLISH*//*);
               date = format.parse(builder.toString());

              *//*  System.out.println(date);
                  System.out.println(builder2.toString());*//*

               PEOPLE.add(new Person(builder2.toString(), date));
           }*/
           reader.close();


       }
    }

