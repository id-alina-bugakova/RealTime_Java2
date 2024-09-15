package ru.mirea.lab4.task2;

public class Skirt extends Clothes implements WomensClothing{
    public Skirt(ClothingSize size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String getDescription() {
        return "A garment fastened around the waist and hanging down around the legs, worn typically by women and girls";
    }

    @Override
    public void dressWoman() {
        System.out.println("Dressed a woman in a skirt");
    }

    @Override
    public String toString() {
        return "Skirt { " +
                "size = " + this.size + ", " +
                "price = " + this.price + ", " +
                "color = " + this.color + " }";
    }
}
