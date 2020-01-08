package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
