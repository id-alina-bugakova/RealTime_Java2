package ru.mirea.lab23.task2;

public interface QueueContract<E> {
    public void push(E data);
    public boolean pop();
    public E peek();
}
