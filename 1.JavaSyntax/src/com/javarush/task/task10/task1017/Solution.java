package com.javarush.task.task10.task1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Безопасное извлечение из списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            int x = Integer.parseInt(reader.readLine());
            list.add(x);
        }

        System.out.println(safeGetElement(list, 5, 1));
        System.out.println(safeGetElement(list, 20, 7));
        System.out.println(safeGetElement(list, -5, 9));
    }

    public static int safeGetElement(ArrayList<Integer> list, int index, int defaultValue) {

        //напишите тут ваш код
        int value;
        try
        {
            value = list.get(index);
        }
        catch (Exception e)
        {
            value = defaultValue;
        }
        return value;
    }

}
   /*     try {
            for (Integer i : list) {
                list.get(i);
            }
            return list.get(index);
        } catch (IndexOutOfBoundsException e){
            return defaultValue;
        }

        //return index;
    }

}*/
