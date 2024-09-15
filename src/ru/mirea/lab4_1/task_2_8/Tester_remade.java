package ru.mirea.lab4_1.task_2_8;

import java.util.ArrayList;

public class Tester_remade {
    public static void test() {
        ArrayList<Shape> arr = new ArrayList<>();
        arr.add(new Circle(5, "FF0000FF", true));
        arr.add(new Rectangle(7, 8, "0000FFFF", true));
        arr.add(new Square(10, "00FF00FF", true));
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
            System.out.println("Area: " + arr.get(i).getArea());
            System.out.println("Perimeter: " + arr.get(i).getPerimeter());
            if(arr.get(i) instanceof Circle) {
                ((Circle) arr.get(i)).setRadius(4);
            }
            else if(arr.get(i) instanceof Square) {
                ((Square) arr.get(i)).setWidth(2);
            }
            else if(arr.get(i) instanceof Rectangle) {
                ((Rectangle) arr.get(i)).setLength(8);
                ((Rectangle) arr.get(i)).setWidth(16);
            }
            System.out.println(arr.get(i).toString());
            System.out.println("New area: " + arr.get(i).getArea());
            System.out.println("New perimeter: " + arr.get(i).getPerimeter() + "\n");
        }
    }
}
