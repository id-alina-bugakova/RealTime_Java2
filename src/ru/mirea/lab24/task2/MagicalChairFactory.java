package ru.mirea.lab24.task2;

public class MagicalChairFactory implements ChairAbstractFactory{
    private String trick;

    public MagicalChairFactory(String trick) {
        this.trick = trick;
    }

    @Override
    public Chair createChair() {
        return new VictorianChair(trick);
    }
}
