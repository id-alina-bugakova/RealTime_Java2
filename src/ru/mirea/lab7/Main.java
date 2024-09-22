package ru.mirea.lab7;

import ru.mirea.lab7.task4.MathFunc;
import ru.mirea.lab7.task5_6.ProcessStrings;
import ru.mirea.lab7.task7_8.*;

public class Main {
    public static void task7_4() {
        MathFunc math = new MathFunc();
        System.out.println(math.pow(4, 1.0/2));
        System.out.println(math.binpow(4, 16));
        System.out.println(math.complex_abs(3, 4));
    }
    public static void task7_56() {
        ProcessStrings str = new ProcessStrings("hello");
        System.out.println(str.size());
        System.out.println(str.getOdd());
        System.out.println(str.reverse());
    }
    public static void task7_78() {
        Printable[] arr = new Printable[4];
        arr[0] = new Book("Heirs of Hope");
        arr[1] = new Book("Crime of the Charred Ringmaster");
        arr[2] = new Magazine("AnyWay but Ordinary");
        arr[3] = new Magazine("Pulse of the Now");
        Magazine.PrintMagazines(arr);
        Book.PrintBooks(arr);
    }

    public static void main(String[] args) {
        task7_78();
    }
}
