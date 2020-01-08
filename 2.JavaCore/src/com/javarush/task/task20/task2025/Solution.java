package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<Long>();
       long[] result = null;
       long S = 1;
        if (N > 0) {
            while (S < N) {
                long M;
                String[] s = String.valueOf(S).split("");
                M = s.length;
                long sum = 0;
                for (int i = 0; i < s.length; i++) {
                    sum += Math.pow(Integer.parseInt(s[i]), M);
                }
                if (S == sum) {
                    list.add(S);
                }
                S++;

            }
        }
       /*     Long[] array = list.toArray(new Long[list.size()]);
            long[] result = new long[array.length];
            for (int i = 0; i < result.length; i++)
                result[i] = array[i];*/
        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNumbers(45521)));
    }
}
