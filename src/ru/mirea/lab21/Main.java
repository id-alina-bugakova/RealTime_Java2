package ru.mirea.lab21;

import ru.mirea.lab21.task1.Converter;
import ru.mirea.lab21.task2_3.Storage;

public class Main {
    public static void task21_1() {
        Integer[] arr_int = new Integer[]{1, 2, 3, 4, 5};
        String[] arr_str = new String[]{"str1", "str2", "str3", "str4", "str5"};
        System.out.println(arr_int);
        System.out.println(Converter.arrayToList(arr_int));
        System.out.println(arr_str);
        System.out.println(Converter.arrayToList(arr_str));
    }
    public static void task21_2_3() {
        Storage storage = new Storage();
        storage.add("string");
        storage.add('c');
        storage.add(1);
        storage.add(2.3);
        System.out.println(storage.toString());
    }

    public static void main(String[] args) {
        task21_2_3();
    }
}
