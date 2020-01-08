package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);
       try (InputStream inputStream = url.openStream()) {

           Path tmp = Files.createTempFile("name-[", "]");
           Files.copy(inputStream, tmp,StandardCopyOption.REPLACE_EXISTING);
           Path result=Paths.get(downloadDirectory.toString(),urlString.split(".+/",2)[1]);
           Files.move(tmp, result, StandardCopyOption.REPLACE_EXISTING);

           return result;
       }
    }
}
