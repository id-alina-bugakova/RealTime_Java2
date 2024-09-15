package ru.mirea.lab4.task3;

import ru.mirea.common.Random;

public class Item {
    private int id;
    private String name;
    private String description;
    private int price;
    private ItemStatus status;
    private int amount;

    public Item() {
        this.id = 0;
        this.name = "";
        this.description = "";
        this.price = 0;
        this.status = ItemStatus.SOLD_OUT;
        this.amount = 0;
    }
    public Item(Item item) {
        this.id = Random.getInt(1, 1000000000);
        this.name = item.name;
        this.description = item.description;
        this.price = item.price;
        this.status = item.status;
        this.amount = item.amount;
    }
    public Item(String name, String description, int price, ItemStatus status, int amount) {
        this.id = Random.getInt(1, 1000000000);
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public int getPrice() {
        return this.price;
    }
    public ItemStatus getStatus() {
        return this.status;
    }
    public int getAmount() {
        return this.amount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public void addToStock(int amount) {
        if(amount > 0) {
            this.amount += amount;
        }
        if(this.amount > 0) {
            if(this.status == ItemStatus.SOLD_OUT)
                this.status = ItemStatus.AVAILABLE;
            else if(this.status == ItemStatus.PREORDER_SOLD_OUT)
                this.status = ItemStatus.PREORDER;
        }
    }
    public boolean sell(int amount) {
        if(amount > 0 && amount <= this.amount) {
            this.amount -= amount;
            if(this.amount == 0) {
                if(this.status == ItemStatus.AVAILABLE)
                    this.status = ItemStatus.SOLD_OUT;
                else if(this.status == ItemStatus.PREORDER)
                    this.status = ItemStatus.PREORDER_SOLD_OUT;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Item { " +
                "id = " + this.id + ", " +
                "name = " + this.name + ", " +
                "description = " + this.description + ", " +
                "price = " + this.price + ", " +
                "status = " + this.status + ", " +
                "amount = " + this.amount + " }";
    }
}
