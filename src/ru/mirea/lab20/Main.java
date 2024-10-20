package ru.mirea.lab20;

import ru.mirea.lab20.task1_3.*;
import ru.mirea.lab20.task4_1.MinMax;
import ru.mirea.lab20.task4_2.Calculator;
import ru.mirea.lab20.task4_2.ComplexNumber;
import ru.mirea.lab20.task5.Matrix;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void task20_1_3() {
        GenericClass<String, Cat, Integer> genericClass = new GenericClass<>("T", new Cat("V"), 11);
        genericClass.getTypes();
    }
    public static void task20_4_1() {
        Random random = new Random();
        Integer[] arr1 = new Integer[10];
        for(int i = 0; i < arr1.length; i++)
            arr1[i] = random.nextInt(100);
        String[] arr2 = {"a", "bra", "ca", "dabra"};
        MinMax<Integer> minMax1 = new MinMax<>(arr1);
        MinMax<String> minMax2 = new MinMax<>(arr2);
        minMax1.update();
        minMax2.update();
        System.out.println("Min: " + minMax1.getMin(false));
        System.out.println("Max: " + minMax1.getMax(false));
        System.out.println("Min: " + minMax2.getMin(false));
        System.out.println("Max: " + minMax2.getMax(false));
    }
    public static void task20_4_2() {
        ComplexNumber a = new ComplexNumber(1, 2);
        ComplexNumber b = new ComplexNumber(3, 4);

        System.out.println(Calculator.add(1, 2));
        System.out.println(Calculator.add(2.4, 3));
        System.out.println(Calculator.add(1, "str"));
        System.out.println(Calculator.add('a', 0));
        System.out.println(Calculator.add(a, b));
        System.out.println(Calculator.subtract(1, 2));
        System.out.println(Calculator.subtract(3, 2.4));
        System.out.println(Calculator.subtract('a', 'b'));
        System.out.println(Calculator.subtract(a, b));
        System.out.println(Calculator.multiply(1, 2));
        System.out.println(Calculator.multiply(2.4, 3));
        System.out.println(Calculator.multiply(5, "str"));
        System.out.println(Calculator.multiply('a', 2));
        System.out.println(Calculator.multiply(a, b));
        System.out.println(Calculator.divide(1, 2));
        System.out.println(Calculator.divide(2.4, 3));
        System.out.println(Calculator.divide('a', 'b'));
        System.out.println(Calculator.divide(a, b));

        System.out.println(Calculator.add(a, 1));
    }
    public static void task20_5() {
        int n = 3;
        Random random = new Random();
        Matrix<Double> mtr1 = new Matrix<>(new int[]{n, n});
        Matrix<Double> mtr2 = new Matrix<>(new int[]{n, n});
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) {
                mtr1.set(i, j, ((Integer)random.nextInt(99)).doubleValue() / 10);
                mtr2.set(i, j, ((Integer)random.nextInt(99)).doubleValue() / 10);
            }
        System.out.println("Matrix mtr1: \n" + mtr1.toString());
        System.out.println("Matrix mtr2: \n" + mtr2.toString());
        System.out.println("Matrix mtr1 + mtr2: \n" + Matrix.add(mtr1, mtr2));
        System.out.println("Matrix mtr1 * mtr2: \n" + Matrix.multiply(mtr1, mtr2));
        System.out.println("Matrix 3 * mtr1: \n" + Matrix.multiply(mtr1, n));
        System.out.println("Det mtr1: " + mtr1.det());
        System.out.println("Inverse mtr1: \n" + mtr1.inverse());
    }

    public static void main(String[] args) {
        task20_4_2();
    }
}
