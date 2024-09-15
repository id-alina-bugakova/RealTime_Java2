package ru.mirea.lab4_1.task_4_1_1_1;

public abstract class Shape {
    Point center;

    public Point getCenter() {
        return this.center;
    }
    public void setCenterXY(double x, double y) {
        this.center.setXY(x, y);
    }

    public abstract String getType();
    public abstract double getArea();
    public abstract double getPerimeter();
}
