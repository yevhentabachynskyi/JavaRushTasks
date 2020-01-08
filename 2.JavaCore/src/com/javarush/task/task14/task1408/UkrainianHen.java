package com.javarush.task.task14.task1408;

/**
 * Created by taye on 04.03.2018.
 */
public class UkrainianHen extends Hen  {
    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }
    String getDescription(){
        return "Я - курица. " + "Моя страна - " + Country.UKRAINE+". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}
