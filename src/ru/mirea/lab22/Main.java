package ru.mirea.lab22;

import ru.mirea.lab22.task1.RPNCalculator;

public class Main {
    public static void task22_1() {
        String[] expressions = {
                "8 9 + 1 7 - *",
                "+1.2 3.2 + -0.4 /"
        };
        for(String expression : expressions)
            System.out.println(expression + " = " + RPNCalculator.solve(expression));
    }

    public static void main(String[] args) {
        task22_1();
    }
}
