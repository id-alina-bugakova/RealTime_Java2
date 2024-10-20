package ru.mirea.lab20.task1_3;

import java.io.Serializable;

public class GenericClass<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T t;
    private V v;
    private K k;

    public GenericClass () {
        this.t = null;
        this.v = null;
        this.k = null;
    }
    public GenericClass (T t, V v, K k) {
        this.t = t;
        this.v = v;
        this.k = k;
    }

    public T getT() {
        return this.t;
    }
    public V getV() {
        return this.v;
    }
    public K getK() {
        return this.k;
    }

    public void getTypes() {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("V: " + v.getClass().getName());
        System.out.println("K: " + k.getClass().getName());
    }
}
