package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.enums.DrinkType;
import com.kbbq999.enums.Size;
import com.kbbq999.menu.Drink;
import com.kbbq999.menu.Order;

public class AddDrinkScreen {

    private Scanner scanner;
    private Order order;

    public AddDrinkScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {
        System.out.println("--- Select Drink ---");
        DrinkType[] types = DrinkType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + formatName(types[i]) + " - $8.00");
        }
    }

    public DrinkType selectDrinkType() {
        DrinkType[] types = DrinkType.values();
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= types.length) return types[choice - 1];
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid. Enter 1-" + types.length + ":");
        }
    }

    public Size selectSize() {
        System.out.println("1) Small  - $8.00");
        System.out.println("2) Medium - $12.00");
        System.out.println("3) Large  - $16.00");
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice == 1) return Size.SMALL;
                if (choice == 2) return Size.MEDIUM;
                if (choice == 3) return Size.LARGE;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid. Enter 1-3:");
        }
    }

    public Drink buildDrink() {
        display();
        DrinkType type = selectDrinkType();
        Size size = selectSize();
        return new Drink(type, size);
    }

    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String formatName(DrinkType type) {
        return switch (type) {
            case SOJU            -> "Soju";
            case MAKGEOLLI       -> "Makgeolli";
            case BARLEY_TEA      -> "Barley Tea";
            case SPARKLING_WATER -> "Sparkling Water";
            case COKE            -> "Coke";
            case JUICE           -> "Juice";
        };
    }
}
