package ru.mirea.lab4.task2;

public class Pants extends Clothes implements MensClothing, WomensClothing{
    public Pants(ClothingSize size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String getDescription() {
        return "An outer garment covering the body from the waist to the ankles, with a separate part for each leg";
    }

    @Override
    public void dressMan() {
        System.out.println("Dressed a man in pants");
    }
    @Override
    public void dressWoman() {
        System.out.println("Dressed a woman in pants");
    }

    @Override
    public String toString() {
        return "Pants { " +
                "size = " + this.size + ", " +
                "price = " + this.price + ", " +
                "color = " + this.color + " }";
    }
}
