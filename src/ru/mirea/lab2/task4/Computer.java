package ru.mirea.lab2.task4;

public class Computer {
    private String model;
    private int price;

    public Computer() {
        this.model = "";
        this.price = 0;
    }
    public Computer(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return this.model;
    }
    public int getPrice() {
        return this.price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public boolean equals(Computer c) {
        return c.getModel().equals(this.model) && c.getPrice() == this.getPrice();
    }
    public boolean equals(String model, int price) {
        return model.equals(this.model) && price == this.price;
    }

    @Override
    public String toString() {
        return "Computer { " +
                "model = " + this.model + ", " +
                "price = " + this.price + " }";
    }
}
