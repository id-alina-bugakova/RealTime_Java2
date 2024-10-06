package ru.mirea.lab13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void task13_4() {
        ArrayList<String> arr_str = new ArrayList<>();
        ArrayList<Shirt> arr_shrt = new ArrayList<>();
        arr_str.add("S001,Black Polo Shirt,Black,XL");
        arr_str.add("S002,Black Polo Shirt,Black,L");
        arr_str.add("S003,Blue Polo Shirt,Blue,XL");
        arr_str.add("S004,Blue Polo Shirt,Blue,M");
        arr_str.add("S005,Tan Polo Shirt,Tan,XL");
        arr_str.add("S006,Black T-Shirt,Black,XL");
        arr_str.add("S007,White TShirt,White,XL");
        arr_str.add("S008,White T-Shirt,White,L");
        arr_str.add("S009,Green T-Shirt,Green,S");
        arr_str.add("S010,Orange T-Shirt,Orange,S");
        arr_str.add("S011,Maroon Polo Shirt,Maroon,S");
        for (String s : arr_str)
            arr_shrt.add(new Shirt(s, ","));
        System.out.println(arr_shrt);
    }
    public static void task13_5() {
        System.out.println(PhoneNumber.formatNumber("+79175655655"));
        System.out.println(PhoneNumber.formatNumber("+104289652211"));
        System.out.println(PhoneNumber.formatNumber("89173634291"));
    }
    public static int findWord(String[] words, boolean[] used, char end) {
        for(int i = 0; i < words.length; i++)
            if(!used[i] && words[i].charAt(0) == end)
                return i;
        return -1;
    }
    public static void task13_6() throws IOException {
        // C:\Users\User\IdeaProjects\RealTime\src\ru\mirea\lab13\words.txt
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String[] words = br.readLine().split(" ");
        boolean[] used = new boolean[words.length];
        int found_res = 0;
        while(found_res != -1) {
            System.out.println(words[found_res]);
            used[found_res] = true;
            found_res = findWord(words, used, words[found_res].charAt(words[found_res].length() - 1));
        }
    }

    public static void main(String[] args) throws IOException {
        task13_6();
    }
}
