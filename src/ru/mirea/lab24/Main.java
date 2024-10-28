package ru.mirea.lab24;

import ru.mirea.lab24.task2.*;

public class Main {
    public static void task24_2() {
        Chair victorianChair = ChairFactory.getChair(new VictorianChairFactory("red"));
        Chair multitoolChair = ChairFactory.getChair(new MultitoolChairFactory("sofa"));
        Chair magicalChair   = ChairFactory.getChair(new MagicalChair("disappearance"));
        Client client = new Client();
        client.sit(victorianChair);
        client.sit(multitoolChair);
        client.sit(magicalChair);
    }

    public static void main(String[] args) {
        task24_2();
    }
}
