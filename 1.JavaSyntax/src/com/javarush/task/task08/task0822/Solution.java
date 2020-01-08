package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    private static int N;
    public static void main(String[] args) throws Exception {


        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));

    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        int res = array.get(0);
        for (Integer i : array)
        {
            if (i < res) res = i;
        }
        return res;

    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a array here - создать и заполнить список тут
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        if (N > 0)
        {

            for (int i = 0; i < N; i++)
            {
                list.add(Integer.parseInt(reader.readLine()));
            }


        }
        else list.add(0);
        return list;

    }
}
