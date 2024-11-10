package ru.mirea.lab30.task1;

public class Node<T extends Comparable<T>> {
    protected T data;
    protected Node<T> left;
    protected Node<T> right;

    public Node(T data) {
        this.data = data;
        this.left = this.right = null;
    }
    public Node(T data, Node<T> child) {
        this.data = data;
        this.left = child;
        this.right = null;
    }
    public Node(T data, Node<T> childLeft, Node<T> childRight) {
        this.data = data;
        this.left = childLeft;
        this.right = childRight;
    }

    public boolean hasLeft() {
        return this.left != null;
    }
    public boolean hasRight() {
        return this.right != null;
    }
    public boolean leaf() {
        return !this.hasLeft() && !this.hasRight();
    }

    public Node<T> getLeft() {
        return this.left;
    }
    public Node<T> getRight() {
        return this.right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
    public void add(T newData) {
        if (newData.compareTo(this.data) < 0) {
            if (this.hasLeft())
                this.left.add(newData);
            else
                this.setLeft(new Node<T>(newData));
        }
        else if (newData.compareTo(this.data) > 0) {
            if (this.hasRight())
                this.right.add(newData);
            else
                this.setRight(new Node<T>(newData));
        }

    }

    public Node<T> copy() {
        Node<T> newNode;
        if(this.leaf())
            newNode = new Node<>(this.data);
        else if(this.hasLeft() && !this.hasRight())
            newNode = new Node<>(this.data, this.left.copy());
        else if(this.hasRight() && !this.hasLeft()) {
            newNode = new Node<>(this.data);
            newNode.setRight(this.right.copy());
        }
        else
            newNode = new Node<>(this.data, this.left.copy(), this.right.copy());
        return newNode;
    }

    @Override
    public String toString() {
        String str = "Node(" + this.data + ")";
        if(!this.leaf()) {
            str += " { ";
            if (this.hasLeft())
                str += this.left.toString();
            if(this.hasLeft() && this.hasRight())
                str += ", ";
            if(this.hasRight())
                str += this.right.toString();
            str += " }";
        }
        return str;
    }
    public String toString(String spaces) {
        String str = "Node(" + this.data + "):\n";
        spaces += "  ";
        if (this.hasLeft())
            str += spaces + "Left  : " + this.left.toString(spaces);
        if (this.hasRight())
            str += spaces + "Right : " + this.right.toString(spaces);
        return str;
    }
}
