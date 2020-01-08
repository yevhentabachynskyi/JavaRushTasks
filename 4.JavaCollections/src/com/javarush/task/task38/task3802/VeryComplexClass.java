package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        BufferedInputStream bufferedInputStream =new BufferedInputStream(new FileInputStream(new File("")));
    }

    public static void main(String[] args) throws Exception{
        new VeryComplexClass().veryComplexMethod();
    }
}
