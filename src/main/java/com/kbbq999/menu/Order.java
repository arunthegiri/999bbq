package com.kbbq999.menu;

import com.kbbq999.enums.Size;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Order {

    private List<MenuItem> items;
    private List<Drink> drinks;
    private List<Side> sides;
    private LocalDateTime orderTime;

    public Order() {
        this.items = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public void addItem(MenuItem item) {}
    public void addDrink(Drink drink) {}
    public void addSide(Side side) {}
    public List<MenuItem> getItems() { return items; }
    public List<Drink> getDrinks() { return drinks; }
    public List<Side> getSides() { return sides; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public double getTotal() { return 0.0; }
    public boolean validate() { return false; }
    public void displayOrder() {}
    public String toString() { return ""; }
}
