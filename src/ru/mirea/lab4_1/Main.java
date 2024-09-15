package ru.mirea.lab4_1;

import ru.mirea.common.Random;
import ru.mirea.lab4_1.task_1_1.Tester;
import ru.mirea.lab4_1.task_2_8.Tester_remade;

public class Main {
    public static void task_4_1_1_1() {
        Tester.test();
    }
    public static void task_4_1_1_4() {
        int ab_n = 3, ab_m = 2, c_n = 2, c_m = 3;
        //double val_min = -10, val_max = 10;
        int val_min = -10, val_max = 10;
        Matrix a = new Matrix(ab_n, ab_m);
        Matrix b = new Matrix(ab_n, ab_m);
        Matrix c = new Matrix(c_n, c_m);
        for(int i = 0; i < ab_n; i++)
            for(int j = 0; j < ab_m; j++) {
                //a.set(i, j, Random.getDouble(val_min, val_max));
                //b.set(i, j, Random.getDouble(val_min, val_max));
                a.set(i, j, Random.getInt(val_min, val_max));
                b.set(i, j, Random.getInt(val_min, val_max));
            }
        for(int i = 0; i < c_n; i++)
            for(int j = 0; j < c_m; j++)
                //c.set(i, j, Random.getDouble(val_min, val_max));
                c.set(i, j, Random.getInt(val_min, val_max));
        System.out.println("A = ");
        a.print();
        System.out.println("B = ");
        b.print();
        System.out.println("C = ");
        c.print();
        System.out.println("A * 5 = ");
        Matrix.prod(a, 5).print();
        System.out.println("A + B = ");
        Matrix.sum(a, b).print();
        System.out.println("A * C = ");
        Matrix.prod(a, c).print();
        System.out.println("A + C = ");
        Matrix.sum(a, c).print();
        System.out.println("A * B = ");
        Matrix.prod(a, b).print();
    }
    public static void task_4_1_2_8() {
        Tester_remade.test();
    }

    public static void main(String[] args) {
        task_4_1_2_8();
    }
}
