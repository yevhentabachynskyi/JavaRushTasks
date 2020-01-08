package com.javarush.task.task14.task1408;

/**
 * Created by taye on 04.03.2018.
 */
public class MoldovanHen extends Hen  {
    @Override
    int getCountOfEggsPerMonth() {
        return 26;
    }
    String getDescription(){
        return "Я - курица. " + "Моя страна - " + Country.MOLDOVA+". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";}
}
