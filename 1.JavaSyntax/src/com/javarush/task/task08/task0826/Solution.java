package com.javarush.task.task08.task0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* 
Пять победителей
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        /*System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);*/
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        for(int i = array.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( array[j] < array[j+1] ){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
            }}}
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);

    /*    for (int i = 0; i < array.length; i++)
        {
            int j = array.length - i - 1;

    }
     */

}}
/*
65465
55
555
51
5415
515
551
511
151
51
115
442
151
51
516
55
56
15
45
4541
*/
