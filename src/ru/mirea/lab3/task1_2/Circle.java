package ru.mirea.lab3.task1_2;

public class Circle implements Comparable<Circle>{
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
    public int compareTo(Circle o) {
        if(this.radius > o.radius)
            return 1;
        else if(this.radius == o.radius)
            return 0;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Circle { " +
                "center = " + this.center.toString() + ", " +
                "radius = " + this.radius + " }";
    }
}
