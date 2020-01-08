package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution implements Person{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        /*while (true*//*(key = reader.readLine()).equals("user") || (key = reader.readLine()).equals("loser") || (key = reader.readLine()).equals("coder")
                || (key = reader.readLine()).equals("proger")*//*) {
            //создаем объект, пункт 2
            if ((key=reader.readLine()).equals("user")) {
                Person user = new Person.User();
                doWork(user);
            } else break;
            if ((key=reader.readLine()).equals("loser")) {
                Person loser = new Person.Loser();
                doWork(loser);
            } else break*//*reader.close()*//*;
            if ((key=reader.readLine()).equals("coder")) {
               Person coder = new Person.Coder();
                doWork(coder);
            } else break;
            if ((key=reader.readLine()).equals("proger")) {
             Person proger = new Person.Proger();
                doWork(proger);
            } else break;

        }*/
        while(true) {
            key = reader.readLine();
            if ("user".equals(key))
                person = new Person.User();
            else if ("loser".equals(key))
                person = new Person.Loser();
            else if ("coder".equals(key))
                person = new Person.Coder();
            else if ("proger".equals(key))
                person = new Person.Proger();
            else break;
            doWork(person); //вызываем doWork
        }

    }

    public static void doWork(Person person) {
        // пункт 3
      if  (person instanceof Person.User)
          ((Person.User) person).live();
        if  (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        if  (person instanceof Person.Coder)
            ((Person.Coder) person).coding();
        if  (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();

    }
}
