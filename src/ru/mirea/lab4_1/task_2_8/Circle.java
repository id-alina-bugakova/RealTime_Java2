package ru.mirea.lab4_1.task_2_8;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
        super();
        this.radius = 0;
    }
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
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
                "color = " + this.color + ", " +
                "filled = " + this.filled + ", " +
                "radius = " + this.radius + " }";
    }
}
