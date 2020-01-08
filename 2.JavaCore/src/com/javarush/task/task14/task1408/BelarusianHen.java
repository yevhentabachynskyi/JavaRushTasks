package com.javarush.task.task14.task1408;

/**
 * Created by taye on 04.03.2018.
 */
public class BelarusianHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 25;
    }
    String getDescription(){
        return "Я - курица. " + "Моя страна - " + Country.BELARUS+". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}
