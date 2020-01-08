package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        List<Integer> list = new ArrayList<Integer>();
        reader.close();
        while (inputStream.available() > 0)
        {
            int data = inputStream.read();
            list.add(data);
        }
        inputStream.close();
/*        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Integer am;
        for (Integer i : list) {
            am = hm.get(i);
            hm.put(i, am == null ? 1 : am + 1);
        }


    int max = Collections.max(hm.keySet());

        System.out.print(max+" ");*/
      //Collections.sort(list);
    int max = 0;
        for (int i = 0; i < list.size(); i++){
            int count = Collections.frequency(list,list.get(i));
            max = (count > max) ? count : max;
            if(count==max){
            System.out.print(list.get(i)+" ");
                list.remove(i);
            }
        }

    }
}
