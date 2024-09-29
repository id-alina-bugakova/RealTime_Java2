package ru.mirea.lab6;

import ru.mirea.lab6.task1.MovableCircle;

import java.util.Scanner;

public class Main {
    public static void task_6_1() {
        MovableCircle mvc = new MovableCircle(0, 0, 2, 3, 5);
        System.out.println(mvc.toString());
        mvc.moveUp();
        mvc.moveRight();
        System.out.println(mvc.toString());
        mvc.moveDown();
        mvc.moveLeft();
        System.out.println(mvc.toString());
    }
    public static void task_6_12() {
        Scanner sc = new Scanner(System.in);
        String help = """
                ---- Commands:                         ---- Types:
                 a - append                             b - boolean
                 d - delete                             c - char
                 i - insert                             i - int
                 r - reverse                            d - double
                 s - replace (substitute)               s - string
                 u - undo
                 h - help (show this message again)
                Commands delete, reverse, replace must be written as one letter.
                    (ex.: d - delete)
                Commands append, insert must contain two letters, the second being the type specificator.
                    (ex.: as - append string)
                After inputting the command, follow the instructions in the console.""";
        System.out.println(help);
        String input;
        StringBuilder builder = new StringBuilder();
        while(true) {
            input = sc.nextLine();
            if (input.charAt(0) == 'a') {
                if (input.charAt(1) == 'b' || input.charAt(1) == 'c' || input.charAt(1) == 'i' ||
                        input.charAt(1) == 'd' || input.charAt(1) == 's') {
                    System.out.println("Input the value in one string:");
                    if (input.charAt(1) == 'b')
                        System.out.println(builder.append(Boolean.parseBoolean(sc.nextLine())));
                    else if (input.charAt(1) == 'c')
                        System.out.println(builder.append(sc.nextLine().charAt(0)));
                    else if (input.charAt(1) == 'i')
                        System.out.println(builder.append(Integer.parseInt(sc.nextLine())));
                    else if (input.charAt(1) == 'd')
                        System.out.println(builder.append(Double.parseDouble(sc.nextLine())));
                    else if (input.charAt(1) == 's')
                        System.out.println(builder.append(sc.nextLine()));
                } else
                    System.out.println("Unknown command. Try again.");
            }
            else if (input.charAt(0) == 'd') {
                int start, end;
                System.out.println("Input the starting index of the substring that will be deleted:");
                start = Integer.parseInt(sc.nextLine());
                System.out.println("Input the end index of the substring that will be deleted:");
                end = Integer.parseInt(sc.nextLine());
                System.out.println(builder.delete(start, end));
            }
            else if (input.charAt(0) == 'i') {
                if (input.charAt(1) == 'b' || input.charAt(1) == 'c' || input.charAt(1) == 'i' ||
                        input.charAt(1) == 'd' || input.charAt(1) == 's') {
                    System.out.println("Input the offset:");
                    int offset = Integer.parseInt(sc.nextLine());
                    System.out.println("Input the value in one string:");
                    if (input.charAt(1) == 'b')
                        System.out.println(builder.insert(offset, Boolean.parseBoolean(sc.nextLine())));
                    else if (input.charAt(1) == 'c')
                        System.out.println(builder.insert(offset, sc.nextLine().charAt(0)));
                    else if (input.charAt(1) == 'i')
                        System.out.println(builder.insert(offset, Integer.parseInt(sc.nextLine())));
                    else if (input.charAt(1) == 'd')
                        System.out.println(builder.insert(offset, Double.parseDouble(sc.nextLine())));
                    else if (input.charAt(1) == 's')
                        System.out.println(builder.insert(offset, sc.nextLine()));
                } else
                    System.out.println("Unknown command. Try again.");
            }
            else if (input.charAt(0) == 'r') {
                System.out.println(builder.reverse());
            }
            else if (input.charAt(0) == 's') {
                int start, end;
                System.out.println("Input the starting index of the substring that will be replaced:");
                start = Integer.parseInt(sc.nextLine());
                System.out.println("Input the end index of the substring that will be replaced:");
                end = Integer.parseInt(sc.nextLine());
                System.out.println("Input the string to replace the selected substring:");
                System.out.println(builder.replace(start, end, sc.nextLine()));
            }
            else if (input.charAt(0) == 'u') {
                System.out.println(builder.undo());
            }
            else if (input.charAt(0) == 'h') {
                System.out.println(help);
            }
            else
                System.out.println("Unknown command. Try again.");
        }
    }

    public static void main(String[] args) {
        task_6_12();
    }
}
