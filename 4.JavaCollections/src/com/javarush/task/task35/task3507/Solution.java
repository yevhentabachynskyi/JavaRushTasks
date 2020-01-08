package com.javarush.task.task35.task3507;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution{
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();
      //  ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try {
           //Class aClass = Class.forName(pathToAnimals);
            File[] files = new File(pathToAnimals).listFiles();
            for (int i=0; i<files.length; i++) {
                if (files[i].getName().endsWith(".class")) {
                    Class aClass = new Loader().loadClass(files[i].getName());
                    if (Animal.class.isAssignableFrom(aClass) && aClass.getDeclaredConstructors()!=null) {
                        Animal a = (Animal) aClass.newInstance();
                        animals.add(a);
                    }
                }
            }
            return animals;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return animals;
    }
    public static class Loader extends ClassLoader {
        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] b = Files.readAllBytes(path);
                return defineClass(className, b, 0, b.length); //here main magic
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
