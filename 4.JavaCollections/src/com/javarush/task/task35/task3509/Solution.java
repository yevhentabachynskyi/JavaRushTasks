package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements){
        //напишите тут ваш код
        ArrayList ts = new ArrayList();
        for (Object o: elements)
            ts.add( o);
        return  ts;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet ts = new HashSet<T>();
        for (Object o: elements)
            ts.add(o);
        return ts;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        HashMap hashMap = new HashMap();
        if(keys.size()==values.size()){
            for (int i=0; i<keys.size();i++)
            hashMap.put(keys.get(i),values.get(i));
            return hashMap;
        }else
        throw new IllegalArgumentException();

    }
}
