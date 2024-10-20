package ru.mirea.lab20.task1_3;

public class Animal {
    private String type;
    private String name;
    private String sound;

    public Animal() {
        this.type = "";
        this.name = null;
        this.sound = "";
    }
    public Animal (String type, String sound) {
        this.type = type;
        this.name = null;
        this.sound = sound;
    }
    public Animal (String type, String name, String sound) {
        this.type = type;
        this.name = name;
        this.sound = sound;
    }

    public void make_sound () {
        if(this.name != null)
            System.out.println(this.type + " " + this.name + " says " + this.sound);
        else
            System.out.println(this.type + " says " + this.sound);
    }
}
