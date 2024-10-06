package ru.mirea.lab_lists2;

import java.util.AbstractMap;

public class SingleLinkedList<E extends Comparable<E>> {
    private Node<E> head, tail;
    private int size;

    public SingleLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }
    private SingleLinkedList(Node<E> head, Node<E> tail, int size) throws CloneNotSupportedException {
        AbstractMap.SimpleEntry<Node<E>, Node<E>> nodes = head.clone(tail);
        this.head = nodes.getKey();
        this.tail = nodes.getValue();
        this.size = size;
    }

    public void addNode(E data) {
        Node<E> node = new Node<>(data);
        if(this.head == null)
            this.head = this.tail = node;
        else {
            this.tail.next = node;
            this.tail = node;
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
    public boolean printElem(int index) {
        if(head == tail)
            return false;
        int i = 0;
        Node<E> cur = this.head;
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

    public void sort() throws CloneNotSupportedException {
        if(this.head == null || this.head == this.tail)
            return;
        int div = this.size / 2;
        int i = 0;
        Node<E> cur = this.head;
        while (i < div - 1) {
            cur = cur.next;
            i++;
        }
        SingleLinkedList<E> sorted1 = new SingleLinkedList<>(this.head, cur, div);
        SingleLinkedList<E> sorted2 = new SingleLinkedList<>(cur.next, this.tail, this.size - div);
        sorted1.sort();
        sorted2.sort();
        this.clear();
        Node<E> cur1 = sorted1.head, cur2 = sorted2.head;
        while(cur1 != null || cur2 != null) {
            if(cur2 == null || (cur1 != null && cur1.getData().compareTo(cur2.getData()) <= 0)) {
                this.addNode(cur1.getData());
                cur1 = cur1.next;
            }
            else {
                this.addNode(cur2.getData());
                cur2 = cur2.next;
            }
        }
    }

    public void print() {
        Node<E> cur = head;
        System.out.println(this.size);
        while(cur != null) {
            System.out.println(cur.toString());
            cur = cur.next;
        }
    }
}
