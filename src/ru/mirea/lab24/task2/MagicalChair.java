package ru.mirea.lab24.task2;

public class MagicalChair implements Chair, ChairAbstractFactory{
    String trick;
    public MagicalChair() {
        this.trick = "none";
    }
    public MagicalChair(String trick) {
        this.trick = trick;
    }

    @Override
    public void sit() {
        System.out.println("You are now sitting in a magical chair. The chair shows you a trick: " + this.trick + "!");
    }

    @Override
    public Chair createChair() {
        return new MagicalChair(trick);
    }

    @Override
    public String toString() {
        return "Magical chair, trick: " + this.trick;
    }
}
