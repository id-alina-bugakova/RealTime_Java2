package ru.mirea.lab23.task3;

public abstract class BinaryOperation implements Operable {
    protected Operable operand1;
    protected Operable operand2;

    public BinaryOperation(Operable operand1, Operable operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public abstract double evaluate(double x0);
}
