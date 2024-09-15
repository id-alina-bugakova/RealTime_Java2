package ru.mirea.lab4;

import ru.mirea.common.Strings;
import ru.mirea.lab4.task2.*;
import ru.mirea.lab4.task3.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void task_4_2 () {
        ArrayList<Clothes> clothes = new ArrayList<Clothes>();
        clothes.add(new TShirt(ClothingSize.M, 1200, "white"));
        clothes.add(new Pants(ClothingSize.M, 2000, "black"));
        clothes.add(new Skirt(ClothingSize.M, 2000, "beige"));
        clothes.add(new Tie(ClothingSize.M, 600, "red"));
        Atelier.dressWoman(clothes);
        Atelier.dressMan(clothes);
    }
    public static void task_4_3() {
        Scanner sc = new Scanner(System.in);
        boolean res;
        Shop.addItem("Electronics", "Computer", "DragonFly 24W235FA2", 1200, ItemStatus.PREORDER, 50);
        Shop.addItem("Electronics", "Phone", "DragonFly Odonata Pro", 600, ItemStatus.AVAILABLE, 100);
        Shop.addItem("Electronics", "Smart watch", "DragonFly Watch 345-O24A", 200, ItemStatus.PREORDER_SOLD_OUT, 0);
        Shop.addItem("Clothes", "T-shirt", "Unisex white t-shirt, one size", 12, ItemStatus.AVAILABLE, 200);
        Shop.addItem("Clothes", "Trousers", "Women's black trousers, sizes 32-48", 20, ItemStatus.AVAILABLE, 100);
        Shop.addItem("Clothes", "Necktie", "8cm/150cm, pheasant pattern", 6, ItemStatus.SOLD_OUT, 0);
        Shop.addItem("Furniture", "Table", "White, 140cm long", 100, ItemStatus.AVAILABLE, 50);
        Shop.addItem("Furniture", "Chair", "Black office chair", 80, ItemStatus.AVAILABLE, 50);
        System.out.println("Add user: input two non-empty strings containing login and password");
        String login = "", password = "";
        while(Strings.emptyLine(login))
            login = sc.nextLine();
        while(Strings.emptyLine(password))
            password = sc.nextLine();
        Shop.addUser(login, password);
        Account me = Shop.getUser(login);
        res = me.authentificate();
        while(!res) {
            System.out.println("Try again");
            res = me.authentificate();
        }
        System.out.println("----- Available catalogues:");
        Shop.displayCatalogues();
        System.out.println("----- Catalogue Electronics:");
        res = Shop.displayCatalogue("Electronics");
        if(!res)
            System.out.println("Failed to display the catalogue");
        System.out.println("----- Catalogue Clothes:");
        res = Shop.displayCatalogue("Clothes");
        if(!res)
            System.out.println("Failed to display the catalogue");
        System.out.println("----- Catalogue Furniture:");
        res = Shop.displayCatalogue("Furniture");
        if(!res)
            System.out.println("Failed to display the catalogue");
        System.out.println("""
                ----- Commands:\s
                    a - add to cart          b - buy the cart
                    c - clear cart           r - remove from cart
                    m - replenish balance    v - view balance
                    s - show cart            p - calculate price
                    d - dispay catalogues
                    l - list of commands     e - exit""");
        char command;
        while(true) {
            command = sc.nextLine().charAt(0);
            if(command == 'a') {
                System.out.println("Input item id: ");
                int id = Integer.parseInt(sc.nextLine());
                Item item = Shop.getItemById(id);
                if(item.getId() == 0)
                    System.out.println("Unknown id");
                else {
                    System.out.println("Input the amount:");
                    int amount = Integer.parseInt(sc.nextLine());
                    res = me.addToCart(item, amount);
                    if(res)
                        System.out.println("Added to cart");
                    else
                        System.out.println("Failed to add to cart");
                }
            }
            else if(command == 'b') {
                res = me.buy();
                if(res)
                    System.out.println("Thank you for the purchase");
                else
                    System.out.println("Failed to purchase");
            }
            else if(command == 'c') {
                me.clearCart();
                System.out.println("Cart cleared");
            }
            else if(command == 'r') {
                System.out.println("Input item id: ");
                int id = Integer.parseInt(sc.nextLine());
                Item item = Shop.getItemById(id);
                if(item.getId() == 0)
                    System.out.println("Unknown id");
                else {
                    System.out.println("Input the amount:");
                    int amount = Integer.parseInt(sc.nextLine());
                    me.removeFromCart(item, amount);
                    System.out.println("The amount has been reduced / the item is no longer in the cart");
                }
            }
            else if(command == 'm') {
                System.out.println("Input the amount:");
                int amount = Integer.parseInt(sc.nextLine());
                res = me.replenishBalance(amount);
                if(res)
                    System.out.println("Current balance: " + me.getBalance());
                else
                    System.out.println("Failed to replenish the balance");
            }
            else if(command == 'v') {
                System.out.println("Current balance: " + me.getBalance());
            }
            else if(command == 's') {
                System.out.println(me.cartToString());
            }
            else if(command == 'p') {
                System.out.println("Price of the cart: " + me.calculatePrice());
            }
            else if(command == 'd') {
                System.out.println("----- Available catalogues:");
                Shop.displayCatalogues();
                System.out.println("----- Catalogue Electronics:");
                res = Shop.displayCatalogue("Electronics");
                if(!res)
                    System.out.println("Failed to display the catalogue");
                System.out.println("----- Catalogue Clothes:");
                res = Shop.displayCatalogue("Clothes");
                if(!res)
                    System.out.println("Failed to display the catalogue");
                System.out.println("----- Catalogue Furniture:");
                res = Shop.displayCatalogue("Furniture");
                if(!res)
                    System.out.println("Failed to display the catalogue");
            }
            else if(command == 'l') {
                System.out.println("""
                        ----- Commands:\s
                            a - add to cart          b - buy the cart
                            c - clear cart           r - remove from cart
                            m - replenish balance    v - view balance
                            s - show cart            d - dispay catalogues
                            l - list of commands     e - exit""");
            }
            else if(command == 'e') {
                break;
            }
            else
                System.out.println("Unknown command. Try again.");
        }
        System.out.println("Thank you for visiting our store");
    }

    public static void main(String[] args) {
        task_4_3();
    }
}
