package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String 	month = reader.readLine();

        /*String 	February = reader.readLine();

        String March = reader.readLine();

        String 	April = reader.readLine();

        String 	May = reader.readLine();

        String June =reader.readLine();

        String July= reader.readLine();

        String August = reader.readLine();

        String September = reader.readLine();

        String October = reader.readLine();

        String November = reader.readLine();

        String 	December = reader.readLine();
*/


     Set<String> mylist= new HashSet<String>();

        mylist.add(month);

    /*    mylist.add(February);

        mylist.add(March);

        mylist.add(April);

        mylist.add(May);

        mylist.add(June);

        mylist.add(July);

        mylist.add(August);

        mylist.add(September);

        mylist.add(October);

        mylist.add(November);

        mylist.add(December);*/

        int[] nomber = {1,2,3,4,5,6,7,8,9,10,11,12};




        if (month.equals("January")){
            System.out.println("January is " + nomber[0]+ " month");
        }else if (month.equals("February")){
            System.out.println("February is " + nomber[1] + " month");
        }else if (month.equals("March")){
            System.out.println("March is " + nomber[2] + " month");
        }else if (month.equals("April")){
            System.out.println("April is " + nomber[3] + " month");
        }else if (month.equals("May")){
            System.out.println("May is " + nomber[4] + " month");
        }else if (month.equals("June")){
            System.out.println("June is " + nomber[5] + " month");
        }else if (month.equals("July")){
            System.out.println("July is " + nomber[6] + " month");
        }else if (month.equals("August")){
            System.out.println("August is " + nomber[7] + " month");
        }else if (month.equals("September")){
            System.out.println("September is " + nomber[8] + " month");
        }else if (month.equals("October")){
            System.out.println("October is " + nomber[9] + " month");
        }else if (month.equals("November")){
            System.out.println("November is " + nomber[10] + " month");
        }else if (month.equals("December")) {
            System.out.println("December is " + nomber[11] + " month");

        }
    }
}
