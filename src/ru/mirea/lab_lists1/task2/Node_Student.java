package ru.mirea.lab_lists1.task2;

import java.util.Scanner;

public class Node_Student {
    private String name;
    private int idNumber;
    private int GPA;
    protected Node_Student prev = null;
    protected Node_Student next = null;

    public Node_Student() {
        this.name = "";
        this.idNumber = -1;
        this.GPA = -1;
    }
    public Node_Student(String name, int idNumber, int GPA) {
        this.name = name;
        this.idNumber = idNumber;
        this.GPA = GPA;
    }

    public String getName() {
        return this.name;
    }
    public int getIdNumber() {
        return this.idNumber;
    }
    public int getGPA() {
        return this.GPA;
    }

    public void inputParams() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the name in one string: ");
        this.name = sc.nextLine();
        System.out.print("Input the id (9-digit number) in one string: ");
        this.idNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Input the id (number from 0 to 100) in one string: ");
        this.GPA = Integer.parseInt(sc.nextLine());
    }
    public void printParams() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Student { " +
                "idNumber = " + this.idNumber + ", " +
                "name = " + this.name + ", " +
                "GPA = " + this.GPA + " }";
    }
}
