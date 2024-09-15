package ru.mirea.lab4_1.task_4_1_1_1;

public class Circle extends Shape{
    double radius;

    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 0;
    }
    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    @Override
    public String getType() {
        return "Circle";
    }
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Circle { " +
                "center = " + this.center.toString() + ", " +
                "radius = " + this.radius + " }";
    }
}
