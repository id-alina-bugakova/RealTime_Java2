package ru.mirea.lab2.task3;

public class Tester {
    private int n;
    private Circle[] arr;

    public Tester() {
        this.n = 0;
        this.arr = new Circle[0];
    }
    public Tester(int n) {
        this.n = n;
        this.arr = new Circle[n];
        for(int i = 0; i < n; i++)
            arr[i] = new Circle();
    }

    public int getN() {
        return this.n;
    }
    public Circle[] getArray() {
        return this.arr;
    }
    public void setCircle(int index, Circle circle) {
        if(index >= 0 && index < this.n) {
            this.arr[index].setCenter(circle.getCenter());
            this.arr[index].setRadius(circle.getRadius());
        }
    }
    public void setCircle(int index, Point point, double radius) {
        if(index >= 0 && index < this.n) {
            this.arr[index].setCenter(point);
            this.arr[index].setRadius(radius);
        }
    }
    public void setCircle(int index, double x, double y, double radius) {
        if(index >= 0 && index < this.n) {
            this.arr[index].setCenterXY(x, y);
            this.arr[index].setRadius(radius);
        }
    }
    public Circle getCircle(int index) {
        if(index >= 0 && index < this.n)
            return this.arr[index];
        else
            return new Circle();
    }

    @Override
    public String toString() {
        String res = "Tester {\n";
        for(int i = 0; i < this.n - 1; ++i)
            res += "  " + this.arr[i].toString() + ",\n";
        res +=  "  " +this.arr[n - 1].toString() + "\n}";
        return res;
    }
}
