package ru.mirea.common;

public class Random {
    public static int getInt (int a, int b) {
        if(a > b)
            a += b - (b = a);    // swap
        return (int)(a + Math.random() * (b - a + 1));
    }

    public static double getDouble (double a, double b) {
        if(a > b)
            a += b - (b = a);    // swap
        return a + Math.random() * (b - a + 1);
    }
}
