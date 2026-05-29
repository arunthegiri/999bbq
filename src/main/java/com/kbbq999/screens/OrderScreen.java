package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.menu.Order;

public class OrderScreen {

    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {}
    public int getUserChoice() { return 0; }
    public void handleInput(int choice) {}
    public void showOrderSummary() {}
}
