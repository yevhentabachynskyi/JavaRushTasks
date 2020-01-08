package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(5461111));
    }

    public static int sumDigitsInNumber(int number) {
        int sum=0;
        //напишите тут ваш код
        while(number!= 0){
            //Суммирование цифр числа
            sum = sum + (number % 10);
            number/=10;
        }
        return sum;
    }
}