package ru.mirea.suffix_automata.suffix_automata;

import java.util.ArrayList;

public class Graph {
    protected ArrayList<ArrayList<Boolean>> matr;

    public Graph(int n) {
        matr = new ArrayList<>();
        this.init(n);
    }

    public void init(int n) {
        for(int i = 0; i < n; i++) {
            matr.add(new ArrayList<Boolean>());
            for(int j = 0; j < n; j++)
                matr.get(i).add(false);
        }
    }

    public int findNull() {  // returns the number of the null-line (the last state of the automata)
        for(int i = 0; i < matr.size(); i++) {
            boolean flag = false;
            for (Boolean b : matr.get(i))
                flag = flag | b;
            if(!flag)
                return i;
        }
        return -1;
    }

    public void print() {
        System.out.println("Graph:");
        for(ArrayList<Boolean> arr : matr) {
            for (Boolean b : arr)
                System.out.print((b ? 1 : 0) + " ");
            System.out.println();
        }
    }
}
