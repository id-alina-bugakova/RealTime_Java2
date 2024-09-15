package ru.mirea.lab4_1.task_4_1_1_1;

import java.util.ArrayList;

public class Tester {
    public static void test() {
        ArrayList<Shape> arr = new ArrayList<>();
        arr.add(new Circle(5, 5, 10));
        arr.add(new Square(-5, -5, 10));
        arr.add(new Rectangle(0, 0, 2, 1));
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).getType());
            System.out.println(arr.get(i).toString());
            System.out.println("Center: " + arr.get(i).getCenter().toString());
            System.out.println("Area: " + arr.get(i).getArea());
            System.out.println("Perimeter: " + arr.get(i).getPerimeter() + "\n");
        }
    }
}
