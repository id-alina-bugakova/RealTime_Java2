package ru.mirea.lab11;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Student {
    private String name;
    private Calendar birthdate;
    private long idNumber;
    private int GPA;

    public Student (String name, Calendar birthdate, long idNumber, int GPA) {
        this.name = name;
        this.birthdate = birthdate;
        this.idNumber = idNumber;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }
    public Calendar getBirthdate() {
        return birthdate;
    }
    public String getBirthdate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(this.birthdate.getTime());
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
                "birthdate = " + this.getBirthdate("dd.MM.yyyy") + ", " +
                "GPA = " + this.GPA + " }";
    }
}
