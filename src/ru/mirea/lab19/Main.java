package ru.mirea.lab19;

import ru.mirea.lab19.task1.OrderMaker;

public class Main {
    public static void task19_1() {
        OrderMaker.placeOrder("A B", "482421351271");
        OrderMaker.placeOrder("C D", "123456789012");
    }
    public static void main(String[] args) {
        task19_1();
    }
}
