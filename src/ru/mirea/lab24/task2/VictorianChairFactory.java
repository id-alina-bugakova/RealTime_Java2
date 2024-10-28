package ru.mirea.lab24.task2;

public class VictorianChairFactory implements ChairAbstractFactory{
    private String color;

    public VictorianChairFactory(String color) {
        this.color = color;
    }

    @Override
    public Chair createChair() {
        return new VictorianChair(color);
    }
}
