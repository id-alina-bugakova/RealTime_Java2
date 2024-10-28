package ru.mirea.lab26.task3;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E>{
    private Node<E> head, tail;
    private int size;

    public LinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void addNode(E data) {
        Node<E> student = new Node<>(data);
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
        Node<E> prev = null, cur = this.head;
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
    public E getElem(int index) {
        //if(head == tail)
        //    return false;
        int i = 0;
        Node<E> cur = this.head;
        while(i != index) {
            if (cur.next != null) {
                cur = cur.next;
                i++;
            }
        }
        return cur.getData();
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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E data = this.current.getData();
                this.current = this.current.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {
        Node<E> cur = head;
        String ret = "LinkedList [" + this.size + "] = {\n";
        while(cur != null) {
            ret += "    " + cur.toString();
            if(cur.next != null)
                ret += ",\n";
            else
                ret += "\n}";
            cur = cur.next;
        }
        return ret;
    }
}