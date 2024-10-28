package ru.mirea.lab23;

import ru.mirea.lab23.task2.LinkedQueue;
import ru.mirea.lab23.task3.*;

import java.util.Random;

public class Main {
    public static void task23_2() {
        int n = 5;
        LinkedQueue<Integer> q = new LinkedQueue<>();
        Random random = new Random();
        for(int i = 0; i < n; i++)
            q.push(random.nextInt(100));
        System.out.println(q.toString());
        System.out.println(q.peek());
        q.pop();
        q.push(random.nextInt(100));
        System.out.println(q.toString());
    }
    public static void task23_3() {
        System.out.println(new Subtract(new Multiply(new Const(2), new Variable("x")), new Const(3)).evaluate(5));
    }

    public static void main(String[] args) {
        task23_3();
    }
}
