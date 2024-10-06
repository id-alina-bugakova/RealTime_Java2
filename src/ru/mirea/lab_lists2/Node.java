package ru.mirea.lab_lists2;

import java.util.AbstractMap;

public class Node<E> {
    private E data;
    protected Node<E> next = null;

    public Node() {
        this.data = null;
    }
    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return this.data;
    }
    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node { " +
                "data = " + this.data.toString() + " }";
    }

    public AbstractMap.SimpleEntry<Node<E>, Node<E>> clone(Node<E> until) throws CloneNotSupportedException {
        if((until == null && this.next == null) || this == until) {
            Node<E> clone = new Node<>(this.data);
            clone.next = null;
            return new AbstractMap.SimpleEntry<>(clone, clone);
        }
        else {
            Node<E> clone = new Node<>(this.data);
            AbstractMap.SimpleEntry<Node<E>, Node<E>> nodes = this.next.clone(until);
            clone.next = nodes.getKey();
            return new AbstractMap.SimpleEntry<>(clone, nodes.getValue());
        }
    }
}
