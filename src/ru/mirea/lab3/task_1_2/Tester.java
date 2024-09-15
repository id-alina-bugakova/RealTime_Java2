package ru.mirea.lab3.task_1_2;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;

public class Tester {
    private int n;
    private ArrayList<Circle> arr;

    public Tester() {
        this.n = 0;
        this.arr = new ArrayList<Circle>();
    }
    public Tester(int n) {
        this.n = n;
        this.arr = new ArrayList<Circle>(0);
        for (int i = 0; i < n; i++)
            arr.add(new Circle());
    }

    public int getN() {
        return this.n;
    }
    public ArrayList<Circle> getArray() {
        return this.arr;
    }

    public void setCircle(int index, Circle circle) {
        if (index >= 0 && index < this.n) {
            this.arr.get(index).setCenter(circle.getCenter());
            this.arr.get(index).setRadius(circle.getRadius());
        }
    }
    public void setCircle(int index, Point point, double radius) {
        if (index >= 0 && index < this.n) {
            this.arr.get(index).setCenter(point);
            this.arr.get(index).setRadius(radius);
        }
    }
    public void setCircle(int index, double x, double y, double radius) {
        if (index >= 0 && index < this.n) {
            this.arr.get(index).setCenterXY(x, y);
            this.arr.get(index).setRadius(radius);
        }
    }
    public Circle getCircle(int index) {
        if (index >= 0 && index < this.n)
            return this.arr.get(index);
        else
            return new Circle();
    }

    public ArrayList<AbstractMap.SimpleEntry<Integer, Circle>> getSmallestCircle() {
        ArrayList<AbstractMap.SimpleEntry<Integer, Circle>> res = new ArrayList<AbstractMap.SimpleEntry<Integer, Circle>>();
        double curSize = 1000000000;
        for (int i = 0; i < this.n; i++) {
            if (this.arr.get(i).getRadius() < curSize) {
                curSize = this.arr.get(i).getRadius();
                res.clear();
                AbstractMap.SimpleEntry<Integer, Circle> circle = new AbstractMap.SimpleEntry<Integer, Circle>(i, this.arr.get(i));
                res.add(circle);
            } else if (this.arr.get(i).getRadius() == curSize) {
                AbstractMap.SimpleEntry<Integer, Circle> circle = new AbstractMap.SimpleEntry<Integer, Circle>(i, this.arr.get(i));
                res.add(circle);
            }
        }
        return res;
    }
    public ArrayList<AbstractMap.SimpleEntry<Integer, Circle>> getLargestCircle() {
        ArrayList<AbstractMap.SimpleEntry<Integer, Circle>> res = new ArrayList<AbstractMap.SimpleEntry<Integer, Circle>>();
        double curSize = 0;
        for (int i = 0; i < this.n; i++) {
            if (this.arr.get(i).getRadius() > curSize) {
                curSize = this.arr.get(i).getRadius();
                res.clear();
                AbstractMap.SimpleEntry<Integer, Circle> circle = new AbstractMap.SimpleEntry<Integer, Circle>(i, this.arr.get(i));
                res.add(circle);
            } else if (this.arr.get(i).getRadius() == curSize) {
                AbstractMap.SimpleEntry<Integer, Circle> circle = new AbstractMap.SimpleEntry<Integer, Circle>(i, this.arr.get(i));
                res.add(circle);
            }
        }
        return res;
    }
    public void sort() {
        Collections.sort(this.arr);
    }

    @Override
    public String toString() {
        String res = "Tester {\n";
        for(int i = 0; i < this.n - 1; ++i)
            res += "  " + this.arr.get(i).toString() + ",\n";
        res +=  "  " +this.arr.get(n - 1).toString() + "\n}";
        return res;
    }
}
