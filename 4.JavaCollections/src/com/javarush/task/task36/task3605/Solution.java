package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<Character>();
        set = new TreeSet<Character>(new The_Comparator());
        try(FileReader reader = new FileReader(args[0]))
        {
            int c;
            while((c=reader.read())!=-1){
                char r = Character.toLowerCase((char) c);
                set.add(r);
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        Stack<Character> stack = new Stack<Character>();
        while (true) {
            if (set.size()>5){
            stack.addAll(set);
            char lastElement = stack.pop();
            set.remove(lastElement);
            stack.clear();
            }
            else break;
        }
        for (Character j: set)
            System.out.print(j);
    }
  public static class The_Comparator implements Comparator<Character> {

        @Override
        public int compare(Character o1, Character o2) {
            if (((o1 >= 'A' && o1 <= 'Z') || (o1 >= 'a' && o1<= 'z')) && ((o2 >= 'A' && o2 <= 'Z') || (o2 >= 'a' && o2<= 'z'))){
            return o1 - o2;
            }
            else return 0;
        }
    }
}
