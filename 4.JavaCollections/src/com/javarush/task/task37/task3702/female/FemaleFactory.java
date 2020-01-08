package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Created by XPMUser on 5/31/19.
 */
public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
        if (age>=0 && age<13)
            return new KidGirl();
        else if (age>=13 && age<20)
            return new TeenGirl();
        else if (age>19)
            return new Woman();
        else return null;
    }
}
