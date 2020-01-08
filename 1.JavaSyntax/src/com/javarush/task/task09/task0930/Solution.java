package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }


    public static void sort(String[] array) {
        /*for(int i=0; i<array.length;i++){  - ВАРІАНТ АНДРІЯ ГОДЛИКА
            if (isNumber(array[i])&& i>0){
                //Nums sorting
                int np=i;
                for (int j=i-1;j>=0;j--){
                    if (isNumber(array[j])&&(Integer.parseInt(array[j])<Integer.parseInt(array[np]))){
                        String temp=array[j];
                        array[j]=array[np];
                        array[np]=temp;
                        np=j;
                    }
                }
            }else{
                //Words sorting
                int np=i;
                for (int j=i-1;j>=0;j--){
                    if (!isNumber(array[j])&&(isGreaterThan(array[j],array[np]))){
                        String temp=array[j];
                        array[j]=array[np];
                        array[np]=temp;
                        np=j;
                    }
                }
            }
        }*/

    ArrayList<Integer> Nums= new ArrayList<Integer>();
        ArrayList<String> Words= new ArrayList<String>();


    for (int i = 0; i<array.length; i++) {
        if (isNumber(array[i]))
            Nums.add(Integer.parseInt(array[i]));
        else if(!isGreaterThan(array[i],array[i]))
            Words.add(array[i]);
    }
        Integer[] TempN=Nums.toArray(new Integer[Nums.size()]);
        Arrays.sort(TempN,Collections.reverseOrder());
        String[] TempW=Words.toArray(new String[Words.size()]);
        Arrays.sort(TempW);
        int tN=0;
        int tW=0;
        for (int i = 0; i<array.length; i++) {
            if (isNumber(array[i]))
                array[i]=TempN[tN++].toString();
            else array[i]=TempW[tW++];
        }

        }
        //напишите тут ваш код
   /*     for(int i = array.length-1 ; i > 0 ; i--){
            isNumber(array[i]);
            for(int j = 0 ; j < i ; j++){
             isGreaterThan(array[i],array[j]);
                if (isNumber(array[i])==true )
            if( array[j] < array[j+1] ){
                int tmp = array[j];
                array[j] = array[j+1];
                array[j+1] = tmp;
asd
7
bsd
9
csd
2
    }}}*/


    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
