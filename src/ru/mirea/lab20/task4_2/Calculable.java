package ru.mirea.lab20.task4_2;

public interface Calculable<T extends Calculable> {
    public Calculable<T> add (T summand2);
    public Calculable<T> subtract (T subtrahend);
    public Calculable<T> multiply (T multiplier2);
    public Calculable<T> divide (T divisor);
}
