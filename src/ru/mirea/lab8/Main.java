package ru.mirea.lab8;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void task8_23_recursion(int cur, int lim, int step) {
        System.out.print(cur + " ");
        if(cur == lim)
            return;
        else
            task8_23_recursion(cur + step, lim, step);
    }
    public static void task8_2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        task8_23_recursion(1, n, 1);
    }
    public static void task8_3(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        task8_23_recursion(a, b, (int)Math.signum(b - a));
    }

    public static int task_8_4_findNumbers(int curSum, int reqSum, int curLen, int reqLen) {
        if(curLen == reqLen && curSum == reqSum)
            return 1;
        if(curLen == reqLen && curSum != reqSum)
            return 0;
        if(curSum > reqSum)
            return 0;
        int ans = 0;
        if(curSum > 0)
            ans += task_8_4_findNumbers(curSum, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 1, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 2, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 3, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 4, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 5, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 6, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 7, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 8, reqSum, curLen + 1, reqLen);
        ans += task_8_4_findNumbers(curSum + 9, reqSum, curLen + 1, reqLen);
        return ans;
    }
    public static void task8_4() {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(), s = sc.nextInt();
        System.out.println(task_8_4_findNumbers(0, s, 0, k));
    }

    public static int task8_5_sum(int number) {
        if(number == 0)
            return 0;
        return number % 10 + task8_5_sum(number / 10);
    }
    public static void task8_5() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(task8_5_sum(n));
    }

    public static boolean task8_6_prime(int n, int d) {
        if(d < 2)
            return true;
        if(d == 2)
            return n % 2 == 1;
        if(n % d != 0)
            return task8_6_prime(n, d - 1);
        else
            return false;
    }
    public static void task8_6() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(task8_6_prime(n, (int)(Math.sqrt(n) + 1))? "Prime" : "Composite");
    }

    static ArrayList<Integer> factors = new ArrayList<>();
    public static void task8_7_factorize(int n, int d) {
        if(d > Math.sqrt(n) + 1) {
            if(n != 1) factors.add(n);
            return;
        }
        while(n % d == 0) {
            factors.add(d);
            n /= d;
        }
        task8_7_factorize(n, d + 1);
    }
    public static void task8_7() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        task8_7_factorize(n, 2);
        for (Integer factor : factors)
            System.out.print(factor + " ");
    }

    public static void main(String[] args) {
        task8_7();
    }
}
