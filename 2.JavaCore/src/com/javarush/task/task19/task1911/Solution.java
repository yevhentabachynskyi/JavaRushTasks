package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
       testString.printSomething();
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
       System.setOut(consoleStream);
        //разворачиваем строку
       StringBuilder stringBuilder = new StringBuilder(result.toUpperCase());
        String string = stringBuilder.toString();

        //выводим ее в консоль
       System.out.println(string);
    }



    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
