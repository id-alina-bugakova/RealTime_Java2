package ru.mirea.suffix_automata;

import ru.mirea.suffix_automata.suffix_automata.SuffixAutomata;
import ru.mirea.suffix_automata.suffix_automata.SuffixProcessor;

import java.util.Scanner;

public class Main {
    public static void test_SA() { // test SuffixAutomata
        String str = "abcbc";
        SuffixAutomata str_sa = new SuffixAutomata(str);
        str_sa.print();
        //str_sa.graph().print();
    }
    public static void test_CFE() { // test SuffixProcessor.checkForEntry
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        SuffixAutomata str_sa = new SuffixAutomata(str);
        while(true) {
            String substr = sc.nextLine();
            System.out.println(SuffixProcessor.checkForEntry(str_sa, substr));
        }
    }
    public static void test_CDS() {  // test SuffixProcessor.countDifferentSubstrings
        // abcbc - 12
        // ababcde - 25
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        SuffixAutomata str_sa = new SuffixAutomata(str);
        System.out.print(SuffixProcessor.countDifferentSubstrings(str_sa));
    }
    public static void main(String[] args) {
        test_CDS();
    }
}
