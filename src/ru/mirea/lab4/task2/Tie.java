package ru.mirea.lab4.task2;

public class Tie extends Clothes implements MensClothing {
    public Tie(ClothingSize size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public String getDescription() {
        return "A strip of material worn round the collar and tied in a knot at the front with the ends hanging down, typically forming part of a man's smart or formal outfit";
    }

    @Override
    public void dressMan() {
        System.out.println("Dressed a man in a tie");
    }

    @Override
    public String toString() {
        return "Tie { " +
                "size = " + this.size + ", " +
                "price = " + this.price + ", " +
                "color = " + this.color + " }";
    }
}
