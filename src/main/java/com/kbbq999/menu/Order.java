package com.kbbq999.menu;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public List<MenuItem> getItems() { return items; }
    public List<Drink> getDrinks() { return drinks; }
    public List<Side> getSides() { return sides; }
    public LocalDateTime getOrderTime() { return orderTime; }

    public double getTotal() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum()
            + drinks.stream().mapToDouble(Drink::getPrice).sum()
            + sides.stream().mapToDouble(Side::getPrice).sum();
    }

    public boolean validate() {
        return !items.isEmpty() || !drinks.isEmpty() || !sides.isEmpty();
    }

    public void displayOrder() {
        System.out.println("=== 999BBQ Order ===");
        if (!items.isEmpty()) {
            System.out.println("--- Plates ---");
            items.forEach(System.out::println);
        }
        if (!drinks.isEmpty()) {
            System.out.println("--- Drinks ---");
            drinks.forEach(System.out::println);
        }
        if (!sides.isEmpty()) {
            System.out.println("--- Sides ---");
            sides.forEach(System.out::println);
        }
        System.out.printf("Total: $%.2f%n", getTotal());
    }

    public String toString() {
        return String.format("Order[%s | %d plate(s), %d drink(s), %d side(s) | Total: $%.2f]",
            orderTime.format(DateTimeFormatter.ofPattern("MM/dd HH:mm")),
            items.size(), drinks.size(), sides.size(), getTotal());
    }
}
