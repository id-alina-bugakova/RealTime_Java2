package ru.mirea.lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void insertion_sort(ArrayList<Student> arr) {
        for(int j = 1; j < arr.size(); j++) {
            Student key = arr.get(j);
            int i = j - 1;
            while(i >= 0 && arr.get(i).getIdNumber() > key.getIdNumber()) {
                arr.set(i + 1, arr.get(i));
                i--;
            }
            arr.set(i + 1, key);
        }
    }
    public static void task9_1() {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("Angela", 23474332, 95));
        arr.add(new Student("Emilia", 21538972, 98));
        arr.add(new Student("Adrian", 12439285, 67));
        arr.add(new Student("Elliot", 54872293, 72));
        arr.add(new Student("Miriam", 93423525, 91));
        arr.add(new Student("Lilian", 45832585, 93));
        insertion_sort(arr);
        for(Student student : arr)
            System.out.println(student.toString());
    }
    public static void task9_2() {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("Angela", 23474332, 95));
        arr.add(new Student("Emilia", 21538972, 98));
        arr.add(new Student("Adrian", 12439285, 67));
        arr.add(new Student("Elliot", 54872293, 72));
        arr.add(new Student("Miriam", 93423525, 91));
        arr.add(new Student("Lilian", 45832585, 93));
        Collections.sort(
                arr,
                (s1, s2) -> {
                    return -Double.compare(s1.getGPA(), s2.getGPA());
                }
            );
        for(Student student : arr)
            System.out.println(student.toString());
    }
    public static List<Student> merge_sort(List<Student> arr) {
        if(arr.size() == 1)
            return arr;
        int divider = arr.size() / 2;
        List<Student> arr1 = merge_sort(arr.subList(0, divider));
        List<Student> arr2 = merge_sort(arr.subList(divider, arr.size()));
        ArrayList<Student> res = new ArrayList<>();
        for(int i = 0, j = 0; i < arr1.size() || j < arr2.size();) {
            if(j == arr2.size() || (i != arr1.size() && arr1.get(i).getName().compareTo(arr2.get(j).getName()) < 1)) {
                res.add(arr1.get(i));
                i++;
            }
            else {
                res.add(arr2.get(j));
                j++;
            }
        }
        return res;
    }
    public static void task9_3() {
        ArrayList<Student> arr1 = new ArrayList<>();
        ArrayList<Student> arr2 = new ArrayList<>();
        arr1.add(new Student("Angela", 23474332, 95));
        arr1.add(new Student("Emilia", 21538972, 98));
        arr1.add(new Student("Adrian", 12439285, 67));
        arr2.add(new Student("Elliot", 54872293, 72));
        arr2.add(new Student("Miriam", 93423525, 91));
        arr2.add(new Student("Lilian", 45832585, 93));
        ArrayList<Student> res = arr1;
        res.addAll(arr2);
        res = (ArrayList<Student>) merge_sort(res);
        for(Student student:res)
            System.out.println(student.toString());
    }

    public static void main(String[] args) {
        task9_3();
    }
}
