package ru.mirea.lab_lists2;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        SingleLinkedList<Student> lst = new SingleLinkedList<>();
        lst.addNode(new Student("Angela", 23474332, 95));
        lst.addNode(new Student("Emilia", 21538972, 98));
        lst.addNode(new Student("Adrian", 12439285, 67));
        lst.addNode(new Student("Elliot", 54872293, 72));
        lst.addNode(new Student("Miriam", 93423525, 91));
        lst.addNode(new Student("Lilian", 45832585, 93));
        lst.sort();
        lst.print();
    }
}
