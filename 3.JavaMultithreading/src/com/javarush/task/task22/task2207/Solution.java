package com.javarush.task.task22.task2207;

import java.util.*;
import java.util.List;
import java.io.*;

/*
D:\1.txt
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    public static Set<Pair> h = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader (System.in));
        String f = reader.readLine();
        reader.close();
        try (BufferedReader breader = new BufferedReader(new FileReader(new File(f)))) {
            String line;

            while ((line = breader.readLine()) != null) {
               // line.replace(" ", "");
                String[] lines = line.split(" ");
                StringBuilder s2 = null;
                for (int i = 1; i < lines.length; i++) {
                    s2 = new StringBuilder(lines[i].toString());
                    s2.reverse();
                    for (int j = 0; j < lines.length; j++) {
                        if (s2.toString().equals(lines[j].toString()) && !lines[j].isEmpty()){
                            Pair pair = new Pair();
                            pair.first=lines[i].trim();
                            pair.second = lines[j].trim();
                            result.add(pair);
                            if (!result.isEmpty())
                            for (Pair p1: result) {
                                if (p1.getFirst().equals(pair.getFirst())&& p1.getSecond().equals(pair.getSecond()))
                                    result.remove(pair);
                            }
                        }
                    }
                }
            }
        /*    for (Pair p1: result){
                for (Pair p2: result){
                    if (p1.getFirst().equals(p2.getFirst()) || p1.getSecond().equals(p2.getSecond()))
                        result.remove(p2);
                }
            }*/
        }
        catch (IOException e) {
                System.err.println(e);
            }

/*        Set<Pair> h = new HashSet<>();
        h.addAll(result);
        result.clear();
        result.addAll(h);*/


        for (Pair pair: result)
           System.out.println(pair);

    }

    public static class Pair {
        String first;
        String second;

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
