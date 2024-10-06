package ru.mirea.lab11;

import ru.mirea.common.Random;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

public class Main {
    public static void task11_1() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd MMMM, yyyy");
        Calendar recieved = Calendar.getInstance();
        recieved.set(Calendar.YEAR, 2024);
        recieved.set(Calendar.MONTH, Calendar.OCTOBER);
        recieved.set(Calendar.DAY_OF_MONTH, 5);
        recieved.set(Calendar.HOUR, 24);
        recieved.set(Calendar.MINUTE, 20);
        recieved.set(Calendar.SECOND, 0);
        Calendar completed = Calendar.getInstance();
        System.out.println("Surname:   Bugakova\nRecieved:  " + sdf.format(recieved.getTime()) + "\nCompleted: " + sdf.format(completed.getTime()));
    }
    public static void task11_3() {
        Calendar birthdate = Calendar.getInstance();
        birthdate.set(Calendar.YEAR, 2004);
        birthdate.set(Calendar.MONTH, Calendar.MAY);
        birthdate.set(Calendar.DAY_OF_MONTH, 26);
        birthdate.set(Calendar.HOUR, 12);
        birthdate.set(Calendar.MINUTE, 0);
        birthdate.set(Calendar.SECOND, 0);
        Student student = new Student("Emilia", birthdate, 21538972, 98);
        System.out.println(student.toString());
        System.out.println(student.getBirthdate("HH:mm:ss dd MMMM, yyyy"));
    }
    public static void task11_5() {
        long beginTime_arr, endTime_arr, beginTime_lnk, endTime_lnk;
        ArrayList<Integer> arrlst = new ArrayList<>();
        LinkedList<Integer> lnklist = new LinkedList<>();
        int n = 50000;
        beginTime_arr = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
            arrlst.add(Random.getInt(0, 10));
        endTime_arr = System.currentTimeMillis();
        beginTime_lnk = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
            arrlst.add(Random.getInt(0, 10));
        endTime_lnk = System.currentTimeMillis();
        System.out.println("ArrayList  time for adding " + n + " elements: " + (endTime_arr - beginTime_arr));
        System.out.println("LinkedList time for adding " + n + " elements: " + (endTime_lnk - beginTime_lnk));
        beginTime_arr = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
            arrlst.add(n / 2, Random.getInt(0, 10));
        endTime_arr = System.currentTimeMillis();
        beginTime_lnk = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
            arrlst.add(n / 2, Random.getInt(0, 10));
        endTime_lnk = System.currentTimeMillis();
        System.out.println("ArrayList  time for inserting " + n + " elements: " + (endTime_arr - beginTime_arr));
        System.out.println("LinkedList time for inserting " + n + " elements: " + (endTime_lnk - beginTime_lnk));
        beginTime_arr = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
            arrlst.remove(n / 2);
        endTime_arr = System.currentTimeMillis();
        beginTime_lnk = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
            arrlst.remove(n / 2);
        endTime_lnk = System.currentTimeMillis();
        System.out.println("ArrayList  time for removing " + n + " elements: " + (endTime_arr - beginTime_arr));
        System.out.println("LinkedList time for removing " + n + " elements: " + (endTime_lnk - beginTime_lnk));
    }

    public static void main(String[] args) {
        task11_5();
    }
}
