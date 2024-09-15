package ru.mirea.lab4.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    private static HashMap<String, ArrayList<Item>> catalogues = new HashMap<String, ArrayList<Item>>();
    private static ArrayList<Account> users = new ArrayList<Account>();

    public static boolean addUser(String login, String password) {
        for (Account account : users)
            if (account.getLogin().equals(login))
                return false;
        Account user = new Account(login, password);
        users.add(user);
        return true;
    }
    public static boolean addCatalogue(String catalogue) {
        for (Map.Entry<String, ArrayList<Item>> entry : catalogues.entrySet())
            if (entry.getKey().equals(catalogue))
                return false;
        catalogues.put(catalogue, new ArrayList<>());
        return true;
    }
    public static void addItem(String catalogue, Item item) {
        if (!catalogues.containsKey(catalogue))
            addCatalogue(catalogue);
        catalogues.get(catalogue).add(new Item(item));
    }
    public static void addItem(String catalogue, String name, String description, int price, ItemStatus status, int amount) {
        if (!catalogues.containsKey(catalogue))
            addCatalogue(catalogue);
        catalogues.get(catalogue).add(new Item(name, description, price, status, amount));
    }

    public static Account getUser(String login) {
        for(Account account : users)
            if(account.getLogin().equals(login))
                return account;
        return new Account("", "");
    }

    public static Item getItemById(int id) {
        for(Map.Entry<String, ArrayList<Item>> entry : catalogues.entrySet())
            for(Item item : entry.getValue())
                if(item.getId() == id)
                    return item;
        return new Item();
    }

    public static void displayCatalogues() {
        System.out.println("Available catalogues:");
        for (Map.Entry<String, ArrayList<Item>> entry : catalogues.entrySet())
            System.out.println(entry.getKey());
    }
    public static boolean displayCatalogue(String catalogue) {
        if (catalogues.containsKey(catalogue)) {
            for (Item item : catalogues.get(catalogue))
                System.out.println("Item " + item.getId() + ": " + item.getName() + " ($" + item.getPrice() + ")\n    " + item.getDescription() + "\n    Status: " + item.getStatus() + ", Available: " + item.getAmount());
            return true;
        }
        return false;
    }
}
