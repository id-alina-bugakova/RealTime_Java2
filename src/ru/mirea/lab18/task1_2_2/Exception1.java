package ru.mirea.lab18.task1_2_2;

public class Exception1 {
    public static void exceptionDemo() {
        try{
            System.out.println(2 / 0);
        } catch ( ArithmeticException e ) {
            System.out.println("Attempted division by zero");
        }
    }
}