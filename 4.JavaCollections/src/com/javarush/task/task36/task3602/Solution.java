package com.javarush.task.task36.task3602;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() throws Exception {
        Class<?>[] classes = Collections.class.getDeclaredClasses();
       /* List list = null;
        for (Class c : classes) {
            if (List.class.isAssignableFrom(c) && Modifier.isPrivate(c.getModifiers()) && Modifier.isStatic(c.getModifiers()) && c.getDeclaredMethod("get", int.class) != null) {
                return c;
            }
        }*/
        return Collections.EMPTY_LIST.getClass();
    }
}