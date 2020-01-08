package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        Path folder = Paths.get(s);
        if(!Files.isDirectory(folder)){
            System.out.println(folder.toAbsolutePath()+ " - не папка");
        }else{
           /* List<Path> folderlist = Files.walk(folder).filter(Files::isDirectory).collect(Collectors.toList());
            List<Path> filelist = Files.walk(folder).filter(Files::isRegularFile).collect(Collectors.toList());
            long size = Files.walk(folder).mapToLong( p -> p.toFile().length() ).sum();
            System.out.println("Всего папок - " + (folderlist.size()-1));
            System.out.println("Всего файлов - " + filelist.size());
            System.out.println("Общий размер - " + size);*/
            List<Path> folderlist =new ArrayList<>();
            List<Path> filelist = new ArrayList<>();
            final AtomicLong size = new AtomicLong(0);

            Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file)){
                    filelist.add(file);
                        size.addAndGet(attrs.size());
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
            Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
            public FileVisitResult postVisitDirectory(Path path, IOException exc) throws IOException {
              folderlist.add(folder);
                return FileVisitResult.CONTINUE;
            }

            });

            System.out.println("Всего папок - " + (folderlist.size()-1));
            System.out.println("Всего файлов - " + filelist.size());
            System.out.println("Общий размер - " + size);
        }
    }
}
