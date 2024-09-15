package ru.mirea.lab2;

import ru.mirea.common.*;
import ru.mirea.lab2.task3.Tester;
import ru.mirea.lab2.task4.Computer;
import ru.mirea.lab2.task4.Shop;

import java.util.AbstractMap;

public class Main {

    public static void task_2_1_testAuthor () {
        Author author = new Author("Jane Doe", "jane@email.com", 'f');
        System.out.println(author.toString());
        System.out.println(author.getName());
        System.out.println(author.getEmail());
        System.out.println(author.getGender());
        author.setEmail("jane_doe@email.com");
        System.out.println(author.toString());
    }
    public static void task_2_2_testBall () {
        Ball ball1 = new Ball(), ball2 = new Ball(10.0, 10.0);
        System.out.println(ball1.toString());
        ball1.setX(5.0);
        ball1.setY(5.0);
        System.out.println(ball1.getX());
        System.out.println(ball1.getY());
        ball1.move(-10.0, 10.0);
        System.out.println(ball1.toString());
        System.out.println((ball2.toString()));
        ball2.setXY(1.0, 1.0);
        System.out.println((ball2.toString()));
    }
    public static void task_2_3_circle_tester() {
        int min_circleNumber = 5,    max_circleNumber = 10,
            min_coord        = -100, max_coord        = 100,
            min_radius       = 0,    max_radius       = 100;
        Tester tester = new Tester(Random.getInt(min_circleNumber, max_circleNumber));
        for(int i = 0; i < tester.getN(); i++)
            tester.setCircle(i, Random.getDouble(min_coord, max_coord),
                                Random.getDouble(min_coord, max_coord),
                                Random.getDouble(min_radius, max_radius));
        System.out.println(tester.toString());
    }
    public static void task_2_4_computerShop() {
        // Copy console input from computers.txt
        Shop shop = new Shop();
        shop.input();
        System.out.println(shop.toString());
        shop.addToStock("Lightning 20948F123AD", 100000, 20);
        shop.sell("Chun NoteBook 2345K-1209AD5847F", 10);
        AbstractMap.SimpleEntry<Computer, Integer> computer = shop.search("Dragonfly 20W110INF");
        System.out.println(computer.toString());
        System.out.println(shop.toString());
    }

    public static void main(String[] args) {
        task_2_4_computerShop();
    }
}
