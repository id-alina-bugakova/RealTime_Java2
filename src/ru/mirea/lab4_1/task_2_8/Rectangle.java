package ru.mirea.lab4_1.task_2_8;

public class Rectangle extends Shape {
    protected double width, length;

    public Rectangle() {
        super();
        this.width = this.length = 0;
    }
    public Rectangle(double width, double length) {
        super();
        this.width = width;
        this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return this.width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return this.length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.width * this.length;
    }
    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "Rectangle { " +
                "color = " + this.color + ", " +
                "filled = " + this.filled + ", " +
                "width = " + this.width + ", " +
                "length = " + this.length + " }";
    }
}
