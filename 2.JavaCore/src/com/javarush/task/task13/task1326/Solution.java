package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/
import java.util.*;


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String f = br.readLine();
        FileInputStream inStream = new FileInputStream(f);
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inStream));
        while (bufferedReader.ready()) {
            int i = Integer.parseInt(bufferedReader.readLine());
            if (i % 2 == 0)
                arrayList.add(i);
        }
        bufferedReader.close();
        Collections.sort(arrayList);
        for (int i :
                arrayList) {
            System.out.println(i);
        }
    }
}


