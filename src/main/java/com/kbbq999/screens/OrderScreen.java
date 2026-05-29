package com.kbbq999.screens;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import com.kbbq999.menu.Drink;
import com.kbbq999.menu.MenuItem;
import com.kbbq999.menu.Order;
import com.kbbq999.menu.Side;

public class OrderScreen {

    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {
        showOrderSummary();
        System.out.println("================================");
        System.out.println("1) Add Item");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Side");
        System.out.println("4) Checkout");
        System.out.println("0) Cancel Order");
    }

    public void showOrderSummary() {
        List<MenuItem> items = order.getItems();
        List<Drink> drinks = order.getDrinks();
        List<Side> sides = order.getSides();

        if (!order.validate()) return;

        System.out.println("--- Current Order (newest first) ---");
        IntStream.iterate(items.size() - 1, i -> i >= 0, i -> i - 1)
            .mapToObj(items::get)
            .forEach(System.out::println);
        IntStream.iterate(drinks.size() - 1, i -> i >= 0, i -> i - 1)
            .mapToObj(drinks::get)
            .forEach(System.out::println);
        IntStream.iterate(sides.size() - 1, i -> i >= 0, i -> i - 1)
            .mapToObj(sides::get)
            .forEach(System.out::println);
        System.out.printf("Subtotal: $%.2f%n", order.getTotal());
    }

    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void handleInput(int choice) {}
}
