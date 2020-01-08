package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
      /*  String args0 = "C:\\6.txt";
        String args1 = "C:\\tmp\\tmp.zip";*/
        File infile = new File(args[0]);
        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();
        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry;
            while ((entry = zipReader.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipReader.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);

                archivedFiles.put(entry.getName(), byteArrayOutputStream);
            }
        }

    try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(args[1]))) {

        ZipEntry entryfile = new ZipEntry("new/" + infile.getName());
        for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
            if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(infile.getName())) continue;
            zout.putNextEntry(new ZipEntry(pair.getKey()));
            zout.write(pair.getValue().toByteArray());
        }

        zout.putNextEntry(new ZipEntry(entryfile.getName()));
        File fil = new File(infile.getAbsolutePath());
        Files.copy(fil.toPath(), zout);
            zout.closeEntry();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

}