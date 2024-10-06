package ru.mirea.lab13;

public class Shirt {
    private String article;
    private String description;
    private String color;
    private String size;

    public Shirt(String shirt, String separator) {
        String[] data = shirt.split(separator);
        if(data.length < 4) {
            this.article = "";
            this.description = "";
            this.color = "";
            this.size = "";
        }
        else {
            this.article = data[0];
            this.description = data[1];
            this.color = data[2];
            this.size = data[3];
        }
    }

    @Override
    public String toString() {
        return "Shirt { " +
                "article = " + this.article + ", " +
                "description = " + this.description + ", " +
                "color = " + this.color + ", " +
                "size = " + this.size + " }";
    }
}
