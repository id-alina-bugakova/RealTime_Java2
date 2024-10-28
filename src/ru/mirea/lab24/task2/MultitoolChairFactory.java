package ru.mirea.lab24.task2;

public class MultitoolChairFactory implements ChairAbstractFactory{
    private String type;

    public MultitoolChairFactory(String type) {
        this.type = type;
    }

    @Override
    public Chair createChair() {
        return new MultitoolChair(type);
    }
}
