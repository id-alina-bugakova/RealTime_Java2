package ru.mirea.lab24.task2;

public class MultitoolChair implements Chair, ChairAbstractFactory{
    String type;
    public MultitoolChair() {
        this.type = "ordinary";
    }
    public MultitoolChair(String type) {
        this.type = type;
    }

    @Override
    public void sit() {
        System.out.println("You are now sitting in a/an " + this.type + " chair");
    }

    @Override
    public Chair createChair() {
        return new MultitoolChair(type);
    }

    @Override
    public String toString() {
        return "Multitool chair, type: " + this.type;
    }
}
