package ru.mirea.lab4_1.task_2_8;

public class Square extends Rectangle {

    public Square() {
        super();
    }
    public Square(double side) {
        super(side, side);
    }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
    @Override
    public void setLength(double length) {
        super.setWidth(length);
        super.setLength(length);
    }

    @Override
    public String toString() {
        return "Square { " +
                "color = " + this.color + ", " +
                "filled = " + this.filled + ", " +
                "side = " + this.width + " }";
    }
}
