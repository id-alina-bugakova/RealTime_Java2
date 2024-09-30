package ru.mirea.lab_lists1.task2;

import java.io.*;

public class DoubleLinkedList {
    private Node_Student head, tail;
    private int size;

    public DoubleLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void addNode() {
        Node_Student student = new Node_Student();
        student.inputParams();
        if(this.head == null)
            this.head = this.tail = student;
        else {
            this.tail.next = student;
            student.prev = this.tail;
            this.tail = student;
        }
        this.size++;
    }
    public boolean removeNode(int index) {
        if(head == null)
            return false;
        if(head == tail) {
            if(index == 0) {
                this.head = this.tail = null;
                this.size--;
                return true;
            }
            else
                return false;
        }
        if(index == 0) {
            this.head = this.head.next;
            this.head.prev = null;
            this.size--;
            return true;
        }
        int i = 0;
        Node_Student prev = null, cur = this.head;
        while(i != index) {
            if (cur.next != null) {
                prev = cur;
                cur = cur.next;
                i++;
            }
            else
                return false;
        }
        prev.next = cur.next;
        if(cur != tail)
            cur.next.prev = prev;
        else
            tail = prev;
        this.size--;
        return true;
    }
    public boolean printElem(int index) {
        if(head == tail)
            return false;
        int i = 0;
        Node_Student cur = this.head;
        while(i != index) {
            if (cur.next != null) {
                cur = cur.next;
                i++;
            }
            else
                return false;
        }
        System.out.println(cur.toString());
        return true;
    }
    public void clear() {
        this.head = this.tail = null;
        this.size = 0;
    }
    public boolean isEmpty() {
        return this.head == null;
    }
    public int size() {
        return this.size;
    }

    public void readFromFile(String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(name));
        this.size = Integer.parseInt(br.readLine());
        this.head = this.tail = null;
        for(int i = 0; i < this.size; i++) {
            Node_Student cur = new Node_Student(br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
            if(this.head == null)
                this.head = this.tail = cur;
            else {
                this.tail.next = cur;
                cur.prev = this.tail;
                this.tail = cur;
            }
        }
    }
    public void writeToFile(String name) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(name));
        Node_Student cur = this.head;
        bw.write(String.valueOf(this.size));
        while(cur != null) {
            bw.newLine();
            bw.write(cur.getName());
            bw.newLine();
            bw.write(String.valueOf(cur.getIdNumber()));
            bw.newLine();
            bw.write(String.valueOf(cur.getGPA()));
            cur = cur.next;
        }
        bw.close();
    }
}
