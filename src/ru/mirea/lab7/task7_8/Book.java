package ru.mirea.lab7.task7_8;

public class Book implements Printable {
    private final String name;
    public Book (String name) {
        this.name = name;
    }

    public static void PrintBooks(Printable[] printables) {
        System.out.println("Books:");
        for(Printable p : printables)
            if(p instanceof Book)
                p.print();
    }

    @Override
    public void print() {
        System.out.println("Book \"" + name + "\"");
    }
}
