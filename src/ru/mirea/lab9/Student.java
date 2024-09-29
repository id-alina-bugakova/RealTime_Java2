package ru.mirea.lab9;

public class Student {
    private String name;
    private long idNumber;
    private int GPA;

    public Student (String name, long idNumber, int GPA) {
        this.name = name;
        this.idNumber = idNumber;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }
    public long getIdNumber() {
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
}
