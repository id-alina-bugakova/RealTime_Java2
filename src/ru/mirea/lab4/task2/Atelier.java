package ru.mirea.lab4.task2;

import java.util.ArrayList;

public class Atelier {
    public static void dressMan(ArrayList<Clothes> clothes) {
        for(int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i) instanceof MensClothing) {
                System.out.println(clothes.get(i).toString());
                System.out.println(clothes.get(i).getDescription());
                ((MensClothing) clothes.get(i)).dressMan();
            }
        }
        System.out.println();
    }
    public static void dressWoman(ArrayList<Clothes> clothes) {
        for(int i = 0; i < clothes.size(); i++) {
            if (clothes.get(i) instanceof WomensClothing) {
                System.out.println(clothes.get(i).toString());
                System.out.println(clothes.get(i).getDescription());
                ((WomensClothing) clothes.get(i)).dressWoman();
            }
        }
        System.out.println();
    }
}
