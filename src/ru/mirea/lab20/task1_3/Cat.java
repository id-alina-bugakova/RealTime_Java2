package ru.mirea.lab20.task1_3;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {
    private static final String TYPE = "Cat";
    private static final String SOUND = "meow";
    public Cat () {
        super(TYPE, SOUND);
    }
    public Cat (String name) {
        super(TYPE, name, SOUND);
    }
}
