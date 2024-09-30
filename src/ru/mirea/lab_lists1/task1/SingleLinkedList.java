package ru.mirea.lab_lists1.task1;

import java.io.*;

public class SingleLinkedList {
    private Node_Student head, tail;
    private int size;

    public SingleLinkedList() {
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
        if(tail == cur)
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
