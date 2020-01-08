package com.javarush.task.task26.task2601;
import java.util.*;
/* 
Почитать в инете про медиану выборки
*/
public class Solution {

        public static void main(String[] args) {
            Integer[] array = {13, 8, 15, 5, 17};
            System.out.println(sort(array));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
    /*    List list = Arrays.asList(array);
        ArrayList<Integer> arraylist = new ArrayList<>(list);
        Collections.sort(arraylist);
        List<Integer> a;
        List<Integer> b;
        int middle = arraylist.size()/2;
        int medianValue = 0; //declare variable
        if (arraylist.size()%2 == 0)
            medianValue = ( arraylist.get(middle-1) +  arraylist.get(middle)) / 2;

        else
            medianValue = arraylist.get(middle);
        a = arraylist.subList(0, arraylist.indexOf(medianValue));
        b = arraylist.subList(arraylist.indexOf(medianValue), arraylist.size());

        Collections.reverse(a);
        List<Integer> result = new ArrayList<>(a.size() + b.size());
        for(int x = 0; x < b.size(); x++) {
            result.add(b.get(x));
        }
        for(int x = 0; x < a.size(); x++) {
            result.add(a.get(x));
        }

        Integer[] newarray = new Integer[result.size()];
        result.toArray(newarray);
       for (int i: newarray)
           System.out.println(i);
        return newarray;*/
        //Находим медиану
        //Сортируем массив из параметра
        int median;
        Arrays.sort(array);
        //Если массив с четным колличеством элементов
        if (array.length%2==0) median = (array[array.length/2] + array[array.length/2-1])/2;
            //И если с нечетным
        else median = array[array.length/2];

        //Сортируем по условию
        Arrays.sort(array,(x,y)->Integer.compare(Math.abs(median-x), Math.abs(median-y)));
        return array;
    }
}
