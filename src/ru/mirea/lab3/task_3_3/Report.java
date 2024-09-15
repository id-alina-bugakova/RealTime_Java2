package ru.mirea.lab3.task_3_3;

import java.util.ArrayList;
import java.util.Collections;

public class Report {
    private static ArrayList<Employee> arr = new ArrayList<Employee>();

    public static void addEmployee(Employee employee) {
        Employee newEmployee = new Employee(employee.getFullname(), employee.getSalary());
        arr.add(newEmployee);
    }
    public static void addEmployee(String fullname, int salary) {
        Employee newEmployee = new Employee(fullname, salary);
        arr.add(newEmployee);
    }

    public static void sort() {
        Collections.sort(arr);
    }

    public static void generateReport() {
        System.out.println("------------- Report --------------");
        System.out.println("      Employee            Salary  ");
        for (Employee employee : arr)
            System.out.printf("%-20s    %10.2f$\n", employee.getFullname(), 0.01 * employee.getSalary());
    }
}
