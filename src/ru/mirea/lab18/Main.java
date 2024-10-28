package ru.mirea.lab18;

public class Main {
    public static void task18_1_1() {
        ru.mirea.lab18.task1_1.Exception1.exceptionDemo();
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
    }
    public static void task18_1_2_1() {
        ru.mirea.lab18.task1_2_1.Exception1.exceptionDemo();
        // Infinity
    }
    public static void task18_1_2_2() {
        ru.mirea.lab18.task1_2_2.Exception1.exceptionDemo();
        // Attempted division by zero
    }
    public static void task18_2_1() {
        ru.mirea.lab18.task2_1.Exception2.exceptionDemo();
        // input: Qwerty 0 1.2 1
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "Qwerty"
        // input: 0
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        // input: 1.2
        // Exception in thread "main" java.lang.NumberFormatException: For input string: "1.2"
        // input: 1
        // 2
    }
    public static void task18_2_3() {
        ru.mirea.lab18.task2_3.Exception2.exceptionDemo();
        // input: Qwerty 0 1.2 1
        // The input is not an integer
        // input: 0
        // Attempted division by zero
        // input: 1.2
        // The input is not an integer
        // input: 1
        // 2
    }
    public static void task18_4() {
        ru.mirea.lab18.task4.Exception2.exceptionDemo();
        // always prints "This will be printed no matter what"
    }

    public static void main(String[] args) {
        task18_4();
    }
}
