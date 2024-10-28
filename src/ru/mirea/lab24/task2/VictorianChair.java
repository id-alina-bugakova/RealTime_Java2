package ru.mirea.lab24.task2;

public class VictorianChair implements Chair{
    String color;
    public VictorianChair() {
        this.color = "white";
    }
    public VictorianChair(String color) {
        this.color = color;
    }

    @Override
    public void sit() {
        System.out.println("You are now sitting in a magnificent " + this.color + " Victorian chair");
    }

    @Override
    public String toString() {
        return "Victorian chair, color: " + this.color;
    }
}
