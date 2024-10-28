package ru.mirea.lab24.task2;

public class ChairFactory {
    public static Chair getChair(ChairAbstractFactory factory) {
        return factory.createChair();
    }
}
