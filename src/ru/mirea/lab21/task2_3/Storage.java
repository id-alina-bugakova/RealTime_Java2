package ru.mirea.lab21.task2_3;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Object> arr;

    public Storage() {
        this.arr = new ArrayList<>();
    }
    public Storage(int size) {
        this.arr = new ArrayList<>();
        for(int i = 0; i < size; i++)
            this.arr.add(null);
    }

    public ArrayList<Object> getArr() {
        return this.arr;
    }

    public Object get (int ind) {
        if(ind < 0 || ind >= this.arr.size())
            throw new IndexOutOfBoundsException("Incorrect index in Storage.get: size = " + this.arr.size() + ", index = " + ind);
        return this.arr.get(ind);
    }

    public <T> void set (int ind, T elem) {
        if(ind < 0 || ind >= this.arr.size())
            throw new IndexOutOfBoundsException("Incorrect index in Storage.set: size = " + this.arr.size() + ", index = " + ind);
        arr.set(ind, (Object)elem);
    }
    public <T> void add (T elem) {
        arr.add((Object)elem);
    }

    @Override
    public String toString() {
        String ret = "Storage = { ";
        for(int i = 0; i < arr.size() - 1; i++)
            ret += arr.get(i).toString() + ", ";
        ret += arr.get(arr.size() - 1) + " }";
        return ret;
    }
}
