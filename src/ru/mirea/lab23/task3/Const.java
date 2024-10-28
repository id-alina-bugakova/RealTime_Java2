package ru.mirea.lab23.task3;

public class Const implements Operable {
    private double value;

    public Const() {
        this.value = 0;
    }
    public Const(int value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
