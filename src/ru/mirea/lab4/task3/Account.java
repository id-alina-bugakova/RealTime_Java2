package ru.mirea.lab4.task3;

import ru.mirea.common.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {
    private String login;
    private String password;
    private boolean logged_in = false;
    private int balance = 0;
    private HashMap<Item, Integer> cart = new HashMap<Item, Integer>();

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        this.logged_in = false;
        System.out.println("Account created");
    }

    protected String getLogin() {
        return this.login;
    }

    public boolean log_in(String login, String password) {
        if(this.login.equals(login) && this.password.equals(password))
            this.logged_in = true;
        return this.logged_in;
    }
    public boolean authentificate() {
        if(this.logged_in) {
            System.out.println("Already logged in");
            return true;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("----- Authentification -----");
        System.out.println("Input login: ");
        String login = sc.nextLine();
        while(Strings.emptyLine(login))
            login = sc.nextLine();
        System.out.println("Input password: ");
        String password = sc.nextLine();
        while(Strings.emptyLine(password))
            password = sc.nextLine();
        if(this.login.equals(login) && this.password.equals(password)) {
            this.logged_in = true;
            System.out.println("Logged in");
        }
        else
            System.out.println("Incorrect login or password");
        return logged_in;
    }
    public void log_out() {
        this.logged_in = false;
        System.out.println("Logged out from the account");
    }

    public int getBalance() {
        return this.balance;
    }
    public boolean replenishBalance(int sum) {
        if(sum > 0) {
            this.balance += sum;
            return true;
        }
        return false;
    }
    protected boolean pay(int sum) {
        if(sum >= 0 && sum <= this.balance) {
            this.balance -= sum;
            return true;
        }
        return false;
    }

    public boolean addToCart(Item item, int amount) {
        if(amount > 0) {
            boolean success = false;
            if ((this.cart.containsKey(item) && this.cart.get(item) + amount <= item.getAmount()) ||
                    (!this.cart.containsKey(item) && amount <= item.getAmount()))
                success = true;
            if (success) {
                if (this.cart.containsKey(item))
                    this.cart.put(item, this.cart.get(item) + amount);
                else
                    this.cart.put(item, amount);
            }
            return success;
        }
        else return false;
    }
    public void removeFromCart(Item item) {
        if(this.cart.containsKey(item))
            this.cart.remove(item);
    }
    public void removeFromCart(Item item, int amount) {
        if(this.cart.containsKey(item)) {
            this.cart.put(item, this.cart.get(item) - amount);
            if (this.cart.get(item) <= 0)
                this.cart.remove(item);
        }
    }
    public void clearCart() {
        this.cart.clear();
    }

    public int calculatePrice() {
        int price = 0;
        for(Map.Entry<Item, Integer> entry : cart.entrySet())
            price += entry.getKey().getPrice() * entry.getValue();
        return price;
    }
    public int calculatePrice(ArrayList<Item> items) {
        int price = 0;
        for (Item item : items)
            if(this.cart.containsKey(item))
                price += item.getPrice() * this.cart.get(item);
        return price;
    }
    public boolean buy() {
        int price = this.calculatePrice();
        boolean paymentCompleted = pay(price);
        if(paymentCompleted) {
            for(Map.Entry<Item, Integer> entry : this.cart.entrySet())
                entry.getKey().sell(entry.getValue());
            this.clearCart();
        }
        return paymentCompleted;
    }
    public boolean buy(ArrayList<Item> items) {
        int price = this.calculatePrice(items);
        boolean paymentCompleted = pay(price);
        if(paymentCompleted) {
            for(Item item : items) {
                item.sell(this.cart.get(item));
                this.removeFromCart(item);
            }
    }
        return paymentCompleted;
    }

    @Override
    public String toString() {
        return "Account { " +
                "login = " + this.login + ", " +
                "password = " + this.password + ", " +
                "logged_in = " + this.logged_in + ", " +
                "balance = " + this.balance + ", " +
                "cart = " + this.cart.toString() + " }";
    }
    public String cartToString() {
        String s = "";
        System.out.println("----- Cart: ");
        for(Map.Entry<Item, Integer> entry : this.cart.entrySet())
            s += entry.toString() + "\n";
        return s;
    }
}
