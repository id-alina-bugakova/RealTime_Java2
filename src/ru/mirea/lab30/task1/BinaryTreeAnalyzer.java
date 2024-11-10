package ru.mirea.lab30.task1;

public class BinaryTreeAnalyzer<T extends Comparable<T>> {
    public int height(Node<T> p) {
        if(p == null)
            return 0;
        int h1 = 0, h2 = 0;
        if(p.hasLeft())
            h1 = height(p.left);
        if(p.hasRight())
            h2 = height(p.right);
        return Integer.max(h1, h2) + 1;
    }
    public void reverse(Node<T> p) {
        Node<T> temp;
        if(p != null) {
            if(p.hasLeft() && p.hasRight()) {
                temp = p.left;
                p.left = p.right;
                p.right = temp;
                reverse(p.left);
                reverse(p.right);
            }
            else if (p.hasLeft() && !p.hasRight()) {
                p.right = p.left;
                p.left = null;
                reverse(p.right);
            }
            else if(p.hasRight() && !p.hasLeft()) {
                p.left = p.right;
                p.right = null;
                reverse(p.left);
            }
        }
    }
    public boolean lookup(Node<T> node, T target) {
        if(node == null)
            return false;
        if(target.compareTo(node.data) == 0)
            return true;
        else if(target.compareTo(node.data) < 0)
            return lookup(node.left, target);
        else
            return lookup(node.right, target);
    }
    public int getWidth(Node<T> root, int level) {
        if(root == null || level < 1)
            return 0;
        if(level == 1)
            return 1;
        return getWidth(root.left, level - 1) + getWidth(root.right, level - 1);
    }
    public int getMaxWidth(Node<T> root) {
        int maxWidth = 0;
        int width = 0;
        int h = height(root);
        for(int i = 0; i < h; i++) {
            width = getWidth(root, i);
            maxWidth = Integer.max(maxWidth, width);
        }
        return maxWidth;
    }
    public int size(Node<T> node) {
        if(node == null)
            return 0;
        return size(node.left) + size(node.right) + 1;
    }
    public boolean sameTree(Node<T> a, Node<T> b) {
        if(a == null && b == null)
            return true;
        if(a != null && b != null)
            return a.data == b.data && sameTree(a.left, b.left) && sameTree(a.right, b.right);
        else
            return false;
    }
}
