package ru.mirea.lab4_1.task_1_1;

import ru.mirea.common.Point;

public class Square extends Shape{
    private double side;

    public Square() {
        this.center = new Point(0, 0);
        this.side = 0;
    }
    public Square(double x, double y, double side) {
        this.center = new Point(x, y);
        this.side = side;
    }

    @Override
    public String getType() {
        return "Square";
    }
    @Override
    public double getArea() {
        return this.side * this.side;
    }
    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square { " +
                "center = " + this.center.toString() + ", " +
                "side = " + this.side + " }";
    }
}
