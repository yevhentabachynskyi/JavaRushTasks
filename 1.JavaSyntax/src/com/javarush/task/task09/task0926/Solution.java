package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> array = new ArrayList<int[]>(5);
        /*5, 2, 4, 7, 0*/
        int[] a ={1,2,3,4,5};
        int[] b ={4,5};
        int[] c ={1,2,3,4};
        int[] d ={1,2,3,4,5,4,5};
        int[] e ={};
        array.add(a);
        array.add(b);
        array.add(c);
        array.add(d);
        array.add(e);
        return array;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
