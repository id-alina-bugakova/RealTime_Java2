package ru.mirea.lab22.task1;

import java.util.Stack;
import java.util.regex.Pattern;

public class RPNCalculator {
    public static double solve(String ex) {
        String[] words = ex.split("\\s+");
        Stack<Double> solver = new Stack<>();
        String regexNumber = "[+-]?\\d+(\\.\\d+)?";
        for(int i = 0; i < words.length; i++)
            if(Pattern.matches(regexNumber, words[i]))
                solver.push(Double.parseDouble(words[i]));
            else if(words[i].equals("+") || words[i].equals("-") || words[i].equals("*") || words[i].equals("/")) {
                if(solver.size() < 2)
                    throw new IncorrectRPNExpression("Incorrect expression in RPNCalculator.solve: less than two numbers left in stack before operation; word " + i);
                Double b = solver.peek();
                solver.pop();
                Double a = solver.peek();
                solver.pop();
                switch (words[i].charAt(0)) {
                    case '+':
                        solver.push(a + b);
                        break;
                    case '-':
                        solver.push(a - b);
                        break;
                    case '*':
                        solver.push(a * b);
                        break;
                    case '/':
                        solver.push(a / b);
                        break;
                }
            }
        if(solver.size() != 1)
            throw new IncorrectRPNExpression("Incorrect expression in RPNCalculator.solve: more than one number left in stack");
        return solver.peek();
    }
}
