package ru.mirea.lab3;

import ru.mirea.common.Random;
import ru.mirea.lab3.task1_2.Tester;
import ru.mirea.lab3.task_3_3.Report;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void task_3_1_2() {
        int n = 10;
        double min_radius = 0,    max_radius = 100,
               min_coord  = -100, max_coord  = 100;
        Tester tester = new Tester(n);
        for(int i = 0; i < n; i++)
            tester.setCircle(i, Random.getDouble(min_coord, max_coord), Random.getDouble(min_coord, max_coord), Random.getDouble(min_radius, max_radius));
        System.out.println(tester.getSmallestCircle().toString());
        System.out.println(tester.getLargestCircle().toString());
        tester.sort();
        System.out.println(tester.toString());
        tester.setCircle(1, tester.getCircle(0));
        System.out.println(tester.getSmallestCircle().toString());
    }
    public static void task_3_1_4() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(n <= 0) {
            System.out.print("Input the size of the array: ");
            n = sc.nextInt();
            if(n <= 0)
                System.out.println("Incorrect size. Try again.");
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            arr.add(Math.abs(ThreadLocalRandom.current().nextInt()) % (n + 1));
            if(arr.get(i) % 2 == 0)
                evens.add(arr.get(i));
        }
        System.out.println(arr);
        System.out.println(evens);

    }
    public static void task_3_2_1() {
        Double doubleObj1 = Double.valueOf("3.512");
        System.out.println(doubleObj1);
        Double doubleObj2 = Double.valueOf("4.125");
        System.out.println(doubleObj2 + "\n");

        System.out.println(Double.parseDouble("8.219") + "\n");

        Double doubleObj = 1025.1025;
        System.out.println((byte)(double)doubleObj);
        System.out.println((short)(double)doubleObj);
        System.out.println((int)(double)doubleObj);
        System.out.println((long)(double)doubleObj);
        System.out.println((float)(double)doubleObj);
        System.out.println((double)doubleObj);
        System.out.println((char)(double)doubleObj + "\n");

        System.out.println(doubleObj + "\n");

        String d = Double.toString(3.14);
        System.out.println(d);
    }
    public static void task_3_3_3() {
        Report.addEmployee("Marianna Johnson", 15000000);
        Report.addEmployee("Veronica Hillsburgh", 20000000);
        Report.addEmployee("Margaret Simens", 16000000);
        Report.addEmployee("Caroline Silver", 1200000);
        Report.sort();
        Report.generateReport();
    }

    public static void main(String[] args) {
        task_3_3_3();
    }
}
