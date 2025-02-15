package com.javarush.task.task24.task2407;

//import com.javarush.task.task24.task2413.Stand;
import java.util.*;
/*
В работе вам иногда будет нужно закастить класс к какому-нибудь интерфейсу (тут Sayable),
который не реализован в текущем классе
 */
public class Cat implements Pet {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    /**
     * Это - механизм адаптирования к другому интерфейсу - Sayable
     * Внутри метода toSayable создайте class CatPet, реализующий интерфейс Sayable
     * Логика метода say:
     * Если i < 1, то вывести на экран, что кот спит. Пример, "Васька спит."'
     * Иначе вывести фразу: "имя_кота говорит мяу!". Пример для i=3, "Васька говорит мяяяу!"
     * <p/>
     * <b>Пример вывода:</b>
     * Мурзик спит.
     * Васька говорит мяяу!
     * Кошка говорит мяяяяяу!
     * Мышь пищит.
     * Томас говорит мяу!
     * <p/>
     * @param i количество букв 'я' в слове мяу
     * @return экземпляр класса CatPet
     */
    public Sayable toSayable(final int i) {
        return new Sayable() {
            @Override
            public String say() {
                if (i < 1){
                return name + " спит.";
                } else if (i >= 1){
          /*          String s = "";
                    for (int j = 1; j <= i; j++) {
                        String z = "я";
                        s = s + z;
                    }
*/
                    return name + " " + String.format("говорит м%sу!", String.join("", Collections.nCopies(i, "я")));
                }
                return null;
            }
        };
    }
}