package ru.mirea.lab4_1;

import java.util.ArrayList;

public class Matrix {
    private int n, m;
    private ArrayList<ArrayList<Double>> matr;

    public Matrix (int n, int m) {
        this.n = n;
        this.m = m;
        this.matr = new ArrayList<ArrayList<Double>>();
        if(n > 0)
            for(int i = 0; i < n; i++) {
                this.matr.add(new ArrayList<Double>());
                if(m > 0)
                    for(int j = 0; j < m; j++)
                        this.matr.get(i).add(j, 0.0);
            }
    }

    public double get(int i, int j) {
        if(i >= 0 && i < n && j >= 0 && j < m)
            return this.matr.get(i).get(j);
        else {
            System.out.println("Incorrect index in Matrix.get");
            return 0;
        }
    }
    public void set(int i, int j, double val) {
        if(i >= 0 && i < this.n && j >= 0 && j < this.m)
            this.matr.get(i).set(j, val);
        else
            System.out.println("Incorrect index in Matrix.set");
    }

    public void print() {
        System.out.println("Matrix {");
        for(int i = 0; i < this.n; i++) {
            System.out.print("    ");
            for(int j = 0; j < this.m; j++)
                System.out.printf("%6.2f ", this.get(i, j));
            System.out.println();
        }
        System.out.println("}");
    }

    public static Matrix sum(Matrix a, Matrix b) {
        if(a.n != b.n || a.m != b.m) {
            System.out.println("Incompatible sizes in Matrix.add");
            return new Matrix(0, 0);
        }
        Matrix res = new Matrix(a.n, a.m);
        for(int i = 0; i < a.n; i++)
            for(int j = 0; j < a.m; j++)
                res.set(i, j, a.get(i, j) + b.get(i, j));
        return res;
    }
    public static Matrix prod(Matrix a, double x) {
        Matrix res = new Matrix(a.n, a.m);
        for(int i = 0; i < a.n; i++)
            for(int j = 0; j < a.m; j++)
                res.set(i, j, x * a.get(i, j));
        return res;
    }
    public static Matrix prod(Matrix a, Matrix b) {
        if(a.m != b.n) {
            System.out.println("Incompatible sizes in Matrix.prod");
            return new Matrix(0, 0);
        }
        Matrix res = new Matrix(a.n, b.m);
        for(int i = 0; i < a.n; i++)
            for(int j = 0; j < b.m; j++)
                for(int k = 0; k < a.m; k++)
                    res.set(i,j, res.get(i,j) + a.get(i, k) * b.get(k, j));
        return res;
    }
}
