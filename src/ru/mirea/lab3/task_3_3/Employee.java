package ru.mirea.lab3.task_3_3;

public class Employee implements Comparable<Employee> {
    private String fullname;
    private int salary;

    public Employee() {
        this.fullname = "";
        this.salary = 0;
    }
    public Employee(String fullname, int salary) {
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getFullname() {
        return this.fullname;
    }
    public int getSalary() {
        return this.salary;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return this.fullname.compareTo(o.fullname);
    }

    @Override
    public String toString() {
        return "Employee { " +
                "fullname = " + this.fullname + ", " +
                "salary = " + this.salary + " }";
    }
}
