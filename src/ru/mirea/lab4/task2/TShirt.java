package ru.mirea.lab4.task2;

public class TShirt extends Clothes implements MensClothing, WomensClothing{
    public TShirt(ClothingSize size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String getDescription() {
        return "A short-sleeved casual top having the shape of a T when spread out flat";
    }

    @Override
    public void dressMan() {
        System.out.println("Dressed a man in a t-shirt");
    }
    @Override
    public void dressWoman() {
        System.out.println("Dressed a woman in a t-shirt");
    }

    @Override
    public String toString() {
        return "TShirt { " +
                "size = " + this.size + ", " +
                "price = " + this.price + ", " +
                "color = " + this.color + " }";
    }
}
