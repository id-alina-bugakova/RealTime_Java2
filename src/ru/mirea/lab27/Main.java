package ru.mirea.lab27;

public class Main {
    public static void main(String[] args) {
        Hashtab<Integer, String> ht = new Hashtab<>();
        ht.add(1, "one");
        ht.add(2, "two");
        ht.add(3, "three");
        ht.add(4, "four");
        ht.add(5, "five");
        ht.add(6, "six");
        ht.add(7, "seven");
        ht.add(8, "eight");
        ht.add(9, "nine");
        ht.add(10, "ten");
        System.out.println(ht.lookup(1));
        ht.delete(5);
        System.out.println(ht);
    }
}
