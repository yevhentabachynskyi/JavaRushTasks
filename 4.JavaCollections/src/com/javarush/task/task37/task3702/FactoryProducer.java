package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

import static com.javarush.task.task37.task3702.FactoryProducer.HumanFactoryType.MALE;

/**
 * Created by XPMUser on 5/31/19.
 */
public class FactoryProducer {
    public static enum HumanFactoryType{
        MALE, FEMALE
    }
    public static  AbstractFactory  getFactory(HumanFactoryType type){
        switch (type) {
            case MALE:
                return new MaleFactory();
            case FEMALE:
                return new FemaleFactory();
        }
        return null;
    }
}
