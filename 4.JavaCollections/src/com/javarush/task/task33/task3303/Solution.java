package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        T obj = null;
        ObjectMapper objMapper = new ObjectMapper();
        obj = objMapper.readValue(new File(fileName), clazz);
        return obj;
    }

    public static void main(String[] args) {

    }
}
