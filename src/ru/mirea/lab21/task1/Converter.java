package ru.mirea.lab21.task1;

import java.util.ArrayList;

public class Converter {
    public static <T> ArrayList<T> arrayToList (T[] arr) {
        ArrayList<T> lst = new ArrayList<>();
        for(T t : arr)
            lst.add(t);
        return lst;
    }
}
