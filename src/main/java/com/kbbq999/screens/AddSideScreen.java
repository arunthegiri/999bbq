package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.menu.Order;
import com.kbbq999.menu.Side;

public class AddSideScreen {

    private Scanner scanner;
    private Order order;

    private static final String[] SIDES = {"Steamed Rice", "Kimchi Jjigae"};

    public AddSideScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {
        System.out.println("--- Select Side ---");
        for (int i = 0; i < SIDES.length; i++) {
            System.out.println((i + 1) + ") " + SIDES[i] + " - $8.00");
        }
    }

    public Side buildSide() {
        display();
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= SIDES.length) {
                    return new Side(SIDES[choice - 1]);
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid. Enter 1-" + SIDES.length + ":");
        }
    }

    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
