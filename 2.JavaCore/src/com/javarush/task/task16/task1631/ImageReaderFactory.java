package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;
import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

import java.io.IOException;

/**
 * Created by XPMUser on 4/3/18.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) throws IOException{
           if (type == ImageTypes.BMP){
               //BmpReader bmp = new BmpReader();
               return new BmpReader();
           }
          else  if (type == ImageTypes.PNG){
               //PngReader png = new PngReader();
                return new PngReader();}
              else  if (type == ImageTypes.JPG){
              // JpgReader jpj = new JpgReader();
               return new JpgReader();
           }
            else  if(type==null){
             throw new IllegalArgumentException("Неизвестный тип картинки");
           }
        return type;

    }
}
