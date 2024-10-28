package ru.mirea.lab26;

import ru.mirea.lab26.task3.LinkedList;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void task26_1() {
        ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr.add(sc.nextInt());
        for(int i = 0; i < n; i++)
            stack.push(arr.get(i));
        for(int i = 0; i < n; i++) {
            arr.set(i, stack.peek());
            stack.pop();
        }
        System.out.println(arr);
    }
    public static void task26_3() {
        Random random = new Random();
        int n = 10;
        LinkedList<Integer> lst = new LinkedList<>();
        for(int i = 0; i < n; i++)
            lst.addNode(random.nextInt(100));
        System.out.println(lst);
        for(Integer elem : lst)
            System.out.print(elem + " ");
    }

    public static void main(String[] args) {
        task26_3();
    }
}
