package ru.mirea.lab_lists2;

public class Student implements Comparable<Student> {
    private String name;
    private int idNumber;
    private int GPA;

    public Student (String name, int idNumber, int GPA) {
        this.name = name;
        this.idNumber = idNumber;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }
    public int getIdNumber() {
        return idNumber;
    }
    public int getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student { " +
                "idNumber = " + this.idNumber + ", " +
                "name = " + this.name + ", " +
                "GPA = " + this.GPA + " }";
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.idNumber, o.idNumber);
    }

}