package com.javarush.task.task35.task3501;

public class GenericStatic {
    public static <T extends Object> T someStaticMethod(Object genericObject) {
        System.out.println((T)genericObject);
        return (T)genericObject;
    }
}
