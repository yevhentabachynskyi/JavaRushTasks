package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property="className")
@JsonSubTypes({
        @JsonSubTypes.Type(value=RacingBike.class, name="Simba" ),
        @JsonSubTypes.Type(value=Car.class, name="Manny"),
        @JsonSubTypes.Type(value=Motorbike.class)
})
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}