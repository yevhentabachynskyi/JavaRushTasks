package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen1 = HenFactory.getHen(Country.BELARUS);
        Hen hen2 = HenFactory.getHen(Country.MOLDOVA);
        Hen hen3 = HenFactory.getHen(Country.RUSSIA);
        Hen hen4 = HenFactory.getHen(Country.UKRAINE);
       //hen1.getCountOfEggsPerMonth();
        System.out.println(hen1.getDescription());
        System.out.println(hen2.getDescription());
        System.out.println(hen3.getDescription());
        System.out.println(hen4.getDescription());
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country == "Ukraine")
                hen = new UkrainianHen();
           else if (country =="Moldova")
                hen = new MoldovanHen();
           else if (country =="Belarus")
                hen = new BelarusianHen();
            else if (country =="Russia")
                hen = new RussianHen();
            //напишите тут ваш код
            return hen;
        }
    }


}
