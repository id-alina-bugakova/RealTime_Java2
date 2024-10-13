package ru.mirea.lab_matchingParentheses;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // [()]{}{[()()]()} - balanced
        // [()]{}{[()()]()}{ - unbalanced
        // [(}{[())]{()]()} - unbalanced
        // [(]) - unbalances
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String sequence = sc.nextLine();
        for(int i = 0; i < sequence.length(); i++) {
            if(sequence.charAt(i) == '(' || sequence.charAt(i) == '[' || sequence.charAt(i) == '{')
                stack.push(sequence.charAt(i));
            else if(!stack.isEmpty() &&
                    ((sequence.charAt(i) == ')' && stack.peek().equals('(')) ||
                    (sequence.charAt(i) == ']' && stack.peek().equals('[')) ||
                    (sequence.charAt(i) == '}' && stack.peek().equals('{'))))
                stack.pop();
            else {
                System.out.println("Unbalanced");
                return;
            }
        }
        if(stack.isEmpty())
            System.out.println("Balanced");
        else
            System.out.println("Unbalanced");
    }
}
