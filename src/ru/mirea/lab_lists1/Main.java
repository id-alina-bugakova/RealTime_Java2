package ru.mirea.lab_lists1;

import ru.mirea.lab_lists1.task1.SingleLinkedList;
import ru.mirea.lab_lists1.task2.DoubleLinkedList;

import java.io.IOException;

public class Main {
    public static void task1() throws IOException {
        SingleLinkedList lst = new SingleLinkedList();
        lst.readFromFile("C:\\Users\\User\\IdeaProjects\\RealTime\\src\\ru\\mirea\\lab_lists1\\students.txt");
        System.out.println(lst.size());
        lst.removeNode(0);
        lst.removeNode(4);
        System.out.println(lst.size());
        lst.addNode();
        System.out.println(lst.size());
        lst.writeToFile("C:\\Users\\User\\IdeaProjects\\RealTime\\src\\ru\\mirea\\lab_lists1\\output1.txt");
    }
    public static void task2() throws IOException {
        DoubleLinkedList lst = new DoubleLinkedList();
        lst.readFromFile("C:\\Users\\User\\IdeaProjects\\RealTime\\src\\ru\\mirea\\lab_lists1\\students.txt");
        System.out.println(lst.size());
        lst.removeNode(0);
        lst.removeNode(4);
        System.out.println(lst.size());
        lst.addNode();
        System.out.println(lst.size());
        lst.writeToFile("C:\\Users\\User\\IdeaProjects\\RealTime\\src\\ru\\mirea\\lab_lists1\\output2.txt");
    }
    public static void task3() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        task2();
    }
}
