package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
      /*  File path = new File("C:\\tmp");
        File resultFileAbsolutePath = new File("C:\\22.txt");*/

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);

        List<File> filelist;
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        FileOutputStream fos = new FileOutputStream(allFilesContent);

        filelist = processFilesFromFolder(path);
        Collections.sort(filelist,Comparator.comparing(File::getName));

        String text = "\n";
        for (File f : filelist) {
                FileInputStream fin = new FileInputStream(f);

                byte[] buffer = new byte[fin.available()];
               byte[] buf = text.getBytes();
                // считываем буфер
                fin.read(buffer, 0, buffer.length);
                // записываем из буфера в файл
                fos.write(buffer, 0, buffer.length);
                fos.write(buf);
                fin.close();
        }
        fos.close();
    }

    public static List<File> processFilesFromFolder(File folder) throws IOException {
        File[] folderEntries = folder.listFiles();
        List<File> resultList = new ArrayList<File>();
        for (File entry : folderEntries)
        {
            if (entry.isFile() && Files.size(entry.toPath()) <= 50)
            {
                resultList.add(entry);

            } else if (entry.isDirectory())
                resultList.addAll(processFilesFromFolder(entry));
        }
        return resultList;
    }
}
