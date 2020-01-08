package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args)  {
        try
        {
            divisionByZero();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void divisionByZero() throws Exception{
       /* double x = Math.random();
        int y = 0;
        double z = (int) x / y;*/
            System.out.println(5/0);
        }



    }

