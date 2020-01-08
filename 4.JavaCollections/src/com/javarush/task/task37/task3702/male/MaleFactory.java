package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by XPMUser on 5/31/19.
 */
public class MaleFactory implements AbstractFactory{
    public Human getPerson(int age){
        if (age>=0 && age<13)
            return new KidBoy();
        else if (age>=13 && age<20)
            return new TeenBoy();
        else if (age>19)
            return new Man();
        else return null;
    }

}
