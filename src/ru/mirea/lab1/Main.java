package ru.mirea.lab1;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void task_1_3()
    // Sum & mean of an integer array
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Input the number of elements: ");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Input " + n + " integer numbers: ");
        int sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
        System.out.println("Mean: " + (1.0 * sum / n));
    }
    public static void task_1_4()
    // Min & max of an integer array using while & do-while
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a row of integer numbers ending with 0 (calculation with while): ");
        int num = 1, min = 1000000000, max = -1000000000;
        while(num != 0) {
            num = sc.nextInt();
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Input a row of integer numbers ending with 0 (calculation with do-while): ");
        min = 1000000000;
        max = -1000000000;
        do {
            num = sc.nextInt();
            min = Math.min(num, min);
            max = Math.max(num, max);
        } while(num != 0);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
    public static void task_1_5(String[] args)
    // Print console arguments
    {
        int n = args.length;
        for(int i = 0; i < n; i++)
            System.out.println(args[i]);
    }
    public static void task_1_6()
    // Print the harmonic series (*)
    {
        int n = 10, m = 10;
        double cur;
        double[][] arr = new double[n][m];
        for(int i = 1; i <= n; i++) {
            cur = 1.0 / i;
            arr[i - 1][10 - (int)Math.round(10 * cur)] = cur;
        }
        DecimalFormat df = new DecimalFormat("#.###  ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                if(arr[j][i] == 0)
                    System.out.print("       ");
                else
                    System.out.print(df.format(arr[j][i]));
            System.out.println();
        }
    }
    public static long factorial_1_7(int a) {
        long res = 1;
        while(a != 0) {
            res *= a;
            a--;
        }
        return res;
    }
    public static void task_1_7()
    // Calculate factorial in a method
    {
        Scanner sc = new Scanner(System.in);
        int a;
        System.out.print("Input an integer number a to find a! :");
        a = sc.nextInt();
        System.out.println(factorial_1_7(a));
    }

    public static void main(String[] args) {
        task_1_7();
    }
}