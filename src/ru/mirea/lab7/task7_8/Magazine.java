package ru.mirea.lab7.task7_8;

public class Magazine implements Printable {
    private final String name;
    public Magazine (String name) {
        this.name = name;
    }

    public static void PrintMagazines(Printable[] printables) {
        System.out.println("Magazines:");
        for(Printable p : printables)
            if(p instanceof Magazine)
                p.print();
    }

    @Override
    public void print() {
        System.out.println("Magazine \"" + name + "\"");
    }
}
