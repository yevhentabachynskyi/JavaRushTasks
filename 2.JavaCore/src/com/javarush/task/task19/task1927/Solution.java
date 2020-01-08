package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/
import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args)  throws Exception {
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
        String r = outputStream.toString();
        System.out.println(r);

        //Возвращаем все как было
     System.setOut(consoleStream);
        String[] result = r.split("\\n");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
           if ((i - 1) % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");

            }
        }

    }


    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
