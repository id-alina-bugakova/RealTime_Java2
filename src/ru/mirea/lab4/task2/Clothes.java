package ru.mirea.lab4.task2;

public abstract class Clothes {
    protected ClothingSize size;
    protected int price;
    protected String color;

    public Clothes(ClothingSize size, int price, String color) {
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public ClothingSize getSize() {
        return this.size;
    }
    public int getPrice() {
        return this.price;
    }
    public String getColor() {
        return this.color;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public abstract String getDescription();
}
