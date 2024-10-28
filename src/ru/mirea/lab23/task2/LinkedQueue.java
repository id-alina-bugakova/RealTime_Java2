package ru.mirea.lab23.task2;

public class LinkedQueue<E> implements QueueContract<E>{
    private Node<E> head, tail;
    private int size;

    public LinkedQueue() {
        this.head = this.tail = null;
        this.size = 0;
    }

    private void addNode(E data) {
        Node<E> student = new Node<>(data);
        if(this.head == null)
            this.head = this.tail = student;
        else {
            this.tail.next = student;
            this.tail = student;
        }
        this.size++;
    }
    private boolean removeNode(int index) {
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
    private E getElem(int index) {
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
    public void push(E data) {
        this.addNode(data);
    }
    @Override
    public boolean pop() {
        return this.removeNode(0);
    }
    @Override
    public E peek() {
        return getElem(0);
    }

    @Override
    public String toString() {
        Node<E> cur = head;
        String ret = "Queue [" + this.size + "] = {\n";
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
