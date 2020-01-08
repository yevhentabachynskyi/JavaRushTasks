package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();
        BufferedReader breader1 = new BufferedReader(new FileReader(f1));
        BufferedReader breader2 = new BufferedReader(new FileReader(f2));
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String line1;
        String line2;
            while ((line1 = breader1.readLine()) != null ) {
                list1.add(line1);
            }
             while ((line2 = breader2.readLine()) != null ) {
            list2.add(line2);
                 System.out.println();
            }
        System.out.println(list1);
        System.out.println(list2);
        for (String s1: list1){
            for (String s2: list2){
                if (list1.contains(s2) && list2.contains(s1)/* && s1.equals(s2)*/) {
                    lines.add(new LineItem(Type.SAME,s1));
                } else if (list1.contains(s2) && !list2.contains(s1)){
                    lines.add(new LineItem(Type.ADDED,s2));
                }else if (!list1.contains(s2) && list2.contains(s1)){
                    lines.add(new LineItem(Type.REMOVED,s1));
                }



            }
        }

/*for (LineItem l: lines)
    System.out.println(String.valueOf(l));*/

          /*      LineItem lineItem = null;
                if (line1==line2){
                    lineItem = new LineItem(Type.SAME,line2);}
                else if (line1==null && line2!=null){
                    lineItem = new LineItem(Type.ADDED,line2);}
                else if (line1!=null && line2==null)
                    lineItem = new LineItem(Type.REMOVED,line1);
                lines.add(lineItem);*/
               


        breader1.close();
        breader2.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

/*

C:\1.txt
C:\2.txt

*/
