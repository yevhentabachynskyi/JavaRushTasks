package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] chArray = str.toCharArray();
        //Arrays.equals(chArray,vowels);
        for (int i = 0; i<chArray.length; i++)
            if (isVowel(chArray[i])==true)
                System.out.print(chArray[i]+" ");
        System.out.println();

        Arrays.equals(chArray,vowels);
        for (int i = 0; i<chArray.length; i++)
            if (isVowel(chArray[i])==false && chArray[i]!=' '){
                System.out.print(chArray[i]+" ");}


     /*       for(int i = 0; i<chArray.length; i++)
            for(int j = 0; j<vowels.length; j++)
            if(chArray[i]==vowels[j])
                System.out.print(vowels[j]+" ");
            else if (chArray[i]!=vowels[j])
                System.out.print(chArray[i]+" ");
        */}



    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}