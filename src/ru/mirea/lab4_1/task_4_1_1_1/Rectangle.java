package ru.mirea.lab4_1.task_4_1_1_1;

public class Rectangle extends Shape{
    double sideA, sideB;

    public Rectangle() {
        this.center = new Point(0, 0);
        this.sideA = sideB = 0;
    }
    public Rectangle(double x, double y, double sideA, double sideB) {
        this.center = new Point(x, y);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public String getType() {
        return "Rectangle";
    }
    @Override
    public double getArea() {
        return this.sideA * this.sideB;
    }
    @Override
    public double getPerimeter() {
        return 2 * (sideA + sideB);
    }

    @Override
    public String toString() {
        return "Rectangle { " +
                "center = " + this.center.toString() + ", " +
                "sideA = " + this.sideA + ", " +
                "sideB = " + this.sideB + " }";
    }
}
