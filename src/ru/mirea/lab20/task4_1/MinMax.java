package ru.mirea.lab20.task4_1;

public class MinMax<T extends Comparable<T>>{
    private final T[] arr;
    private T min = null;
    private T max = null;

    public MinMax(T[] arr) {
        this.arr = arr;
    }

    public T getMin(boolean update) {
        if(update)
            this.update();
        return this.min;
    }
    public T getMax(boolean update) {
        if(update)
            this.update();
        return this.max;
    }

    public void update() {
        if(arr.length != 0) {
            T cur_min = arr[0], cur_max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i].compareTo(cur_min) < 0)
                    cur_min = arr[i];
                if(arr[i].compareTo(cur_max) > 0)
                    cur_max = arr[i];
            }
            this.min = cur_min;
            this.max = cur_max;
        }
        else {
            this.min = null;
            this.max = null;
        }
    }
}
