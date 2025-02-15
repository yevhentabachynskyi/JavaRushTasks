package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {

        User userUra = new User("Юра", "Карп", 28);

        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        AtomicInteger calc = new AtomicInteger();

        calc.set(base.get() + age / 100);
        calc.set((int) (calc.get() * (hasWork ? 1.1 : 0.9)));
        calc.set((int) (calc.get() * (hasHouse ? 1.1 : 0.9)));

        return calc.get();
    }

    public String getBossName(User user) {
       //Work work = user.getWork();
        return user.getBoss();
    }
}