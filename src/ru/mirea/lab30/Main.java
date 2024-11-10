package ru.mirea.lab30;

import ru.mirea.lab30.huffmanCoding.HuffmanCoding;
import ru.mirea.lab30.task1.BinaryTreeAnalyzer;
import ru.mirea.lab30.task1.Node;

import java.util.Scanner;

public class Main {
    public static void huffmanCoding() {
        // sdhgfhsdhsdf
        Scanner sc = new Scanner(System.in);
        HuffmanCoding hc = new HuffmanCoding(sc.nextLine());
        System.out.println(hc.process());
    }
    public static void task30_1() {
        int[] data = new int[]{5, 4, 8, 2, 6, 10, 1, 3, 7, 9, 12, 11, 13};
        //int[] data = new int[]{2, 1, 4, 3, 5};
        Node<Integer> tree = new Node<>(data[0]);
        BinaryTreeAnalyzer<Integer> bta = new BinaryTreeAnalyzer<>();
        for(int i = 1; i < data.length; i++)
            tree.add(data[i]);
        Node<Integer> tree_copy = tree.copy();

        System.out.println(tree.toString(""));
        System.out.println("Height: " + bta.height(tree));
        bta.reverse(tree);
        System.out.println("Reverse: " + tree.toString(""));
        bta.reverse(tree);
        System.out.println("Lookup(12): " + bta.lookup(tree, 12));
        System.out.println("Lookup(17): " + bta.lookup(tree, 17));
        System.out.println("MaxWidth: " + bta.getMaxWidth(tree));
        System.out.println("Size: " + bta.size(tree));
        System.out.println("SameTree: " + bta.sameTree(tree, tree_copy));
    }
    public static void main(String[] args) {
        task30_1();
    }
}
