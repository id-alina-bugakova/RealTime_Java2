package ru.mirea.lab2.task4;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop implements Inputable {
    private int number_of_models;
    private HashMap<Computer, Integer> computers;
    private static Scanner sc = new Scanner(System.in);

    public Shop() {
        number_of_models = 0;
        computers = new HashMap<Computer, Integer>();
    }

    @Override
    public void input() {
        System.out.print("Input the information about the computers.\nNumber of models:");
        this.number_of_models = sc.nextInt();
        System.out.println("Input a line and two integers for each model - model number, price and amount in stock: ");
        for(int i = 0; i < this.number_of_models; i++) {
            sc.nextLine();
            computers.put(new Computer(sc.nextLine(), sc.nextInt()), sc.nextInt());
        }
    }

    public void addToStock(String model, int price, int amount) {
        boolean found = false;
        for(Map.Entry<Computer, Integer> entry : computers.entrySet())
            if(entry.getKey().equals(model, price)) {
                found = true;
                computers.put(entry.getKey(), entry.getValue() + amount);
                break;
            }
        if(!found) {
            Computer newComputer = new Computer(model, price);
            computers.put(newComputer, amount);
        }
    }
    public void addToStock(Computer computer, int amount) {
        boolean found = false;
        for(Map.Entry<Computer, Integer> entry : computers.entrySet())
            if(entry.getKey().equals(computer)) {
                found = true;
                computers.put(entry.getKey(), entry.getValue() + amount);
                break;
            }
        if(!found) {
            computers.put(computer, amount);
        }
    }
    public boolean sell(String model, int amount) {
        for(Map.Entry<Computer, Integer> entry : computers.entrySet())
            if(entry.getKey().getModel().equals(model)) {
                if(entry.getValue() - amount >= 0) {
                    computers.put(entry.getKey(), entry.getValue() - amount);
                    return true;
                }
                else {
                    computers.put(entry.getKey(), 0);
                    return false;
                }
            }
        return false;
    }
    public boolean sell(Computer computer, int amount) {
        for(Map.Entry<Computer, Integer> entry : computers.entrySet())
            if(entry.getKey().equals(computer)) {
                if(entry.getValue() - amount >= 0) {
                    computers.put(entry.getKey(), entry.getValue() - amount);
                    return true;
                }
                else {
                    computers.put(entry.getKey(), 0);
                    return false;
                }
            }
        return false;
    }
    public AbstractMap.SimpleEntry<Computer, Integer> search(String model) {
        for(Map.Entry<Computer, Integer> entry : computers.entrySet())
            if(entry.getKey().getModel().equals(model)) {
                return new AbstractMap.SimpleEntry<Computer, Integer>(entry.getKey(), entry.getValue());
            }
        return new AbstractMap.SimpleEntry<Computer, Integer>(new Computer(), 0);
    }

    @Override
    public String toString() {
        return this.computers.toString();
    }
}
