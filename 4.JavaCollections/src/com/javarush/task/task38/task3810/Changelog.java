package com.javarush.task.task38.task3810;

import java.lang.annotation.*;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface Changelog {
    //напиши свой код
    Revision[] value();
}
