package ru.mirea.lab4.task2;

public enum ClothingSize {
    XXS(32),
    XS (34),
    S  (36),
    M  (38),
    L  (40),
    XL (42),
    XXL(44);

    private final int euroSize;

    private ClothingSize(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription() {
        if(this.euroSize == XXS.euroSize)
            return "Children's size";
        else
            return "Adults' size";
    }
}
