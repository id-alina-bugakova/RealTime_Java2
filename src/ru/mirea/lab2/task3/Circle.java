package ru.mirea.lab2.task3;

public class Circle {
    private Point center;
    private double radius;

    public Circle() {
        this.center = new Point(0.0, 0.0);
        this.radius = 0.0;
    }
    public Circle(double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }
    public void setCenter(Point center) {
        this.center.setXY(center.getX(), center.getY());
    }
    public void setCenterXY(double x, double y) {
        this.center.setXY(x, y);
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle { " +
                "center = " + this.center.toString() + ", " +
                "radius = " + this.radius + " }";
    }
}
