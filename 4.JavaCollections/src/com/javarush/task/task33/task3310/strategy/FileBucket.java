package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("sample-file", ".txt");
            Files.deleteIfExists(path);
            Files.createFile(path);
            path.toFile().deleteOnExit();
        } catch (IOException e) {
        }
    }

    public long getFileSize() throws IOException {
        return Files.size(path);
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(entry);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public Entry getEntry() {
        Entry e = null;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            e = (Entry) ois.readObject();
            if (getFileSize()>0)
            return e;
            else return null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return e;
    }


    public void remove() throws IOException{
        Files.delete(path);}
}
