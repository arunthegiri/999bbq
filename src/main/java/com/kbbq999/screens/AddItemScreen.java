package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.enums.MealType;
import com.kbbq999.enums.Size;
import com.kbbq999.enums.ToppingCategory;
import com.kbbq999.menu.BBQPlate;
import com.kbbq999.menu.Order;
import com.kbbq999.menu.Topping;

public class AddItemScreen {

    private static final String[] MEATS = {
        "Australian Wagyu", "Brisket", "Galbi", "Pork Belly", "Bulgogi", "Spicy Bulgogi"
    };
    private static final String[] PREMIUMS = {
        "Salmon Roe", "Corn Cheese", "Snow Crab", "Steamed Egg"
    };
    private static final String[] REGULARS = {
        "Kimchi", "Bean Sprouts", "Spinach", "Mushrooms", "Corn",
        "Cucumber", "Onion", "Perilla Leaf", "Radish"
    };
    private static final String[] CONDIMENTS = {
        "Gochujang", "Ssamjang", "Sesame Oil", "Garlic Butter", "Yuzu Ponzu", "Doenjang"
    };

    private Scanner scanner;
    private Order order;

    public AddItemScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {
        System.out.println("--- Select Meal Type ---");
        MealType[] types = MealType.values();
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ") " + types[i]);
        }
    }

    public MealType selectMealType() {
        System.out.println("1) KBBQ  2) SOUP  3) HOTPOT  4) OMAKASE");
        MealType[] types = MealType.values();
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= types.length) return types[choice - 1];
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid. Enter 1-" + types.length + ":");
        }
    }

    public Size selectSize() {
        System.out.println("1) Small  - $45.00");
        System.out.println("2) Medium - $75.00");
        System.out.println("3) Large  - $120.00");
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

    public void selectToppings(BBQPlate plate) {
        pickToppings(plate, "MEATS",            MEATS,     ToppingCategory.MEAT,      true);
        pickToppings(plate, "PREMIUM TOPPINGS", PREMIUMS,  ToppingCategory.PREMIUM,   true);
        pickToppings(plate, "REGULAR TOPPINGS", REGULARS,  ToppingCategory.REGULAR,   false);
        pickToppings(plate, "CONDIMENTS",       CONDIMENTS,ToppingCategory.CONDIMENT, false);
    }

    public BBQPlate buildPlate() {
        MealType mealType = selectMealType();
        Size size = selectSize();
        BBQPlate plate = new BBQPlate(mealType.name(), size, mealType);
        selectToppings(plate);
        System.out.println("All-You-Can-Eat? (+$35.00) (y/n):");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            plate.toggleAllYouCanEat();
        }
        System.out.println("\n" + plate);
        System.out.println("1) Add to cart");
        System.out.println("2) Back to menu");
        while (true) {
            String input = scanner.nextLine().trim();
            if ("1".equals(input)) {
                order.addItem(plate);
                System.out.println("Added to order!");
                return plate;
            } else if ("2".equals(input)) {
                return null;
            }
        }
    }

    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void pickToppings(BBQPlate plate, String header, String[] options,
                               ToppingCategory category, boolean canBeExtra) {
        System.out.println("\n--- " + header + " (0 to skip) ---");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ") " + options[i]);
        }
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.equals("0")) break;
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("\n--- " + header + " (0 to skip) ---");
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + ") " + options[i]);
                }
                continue;
            }
            if (choice < 1 || choice > options.length) {
                System.out.println("\n--- " + header + " (0 to skip) ---");
                for (int i = 0; i < options.length; i++) {
                    System.out.println((i + 1) + ") " + options[i]);
                }
                continue;
            }
            String name = options[choice - 1];
            boolean isExtra = false;
            if (canBeExtra) {
                System.out.println("Extra? (y/n):");
                isExtra = scanner.nextLine().trim().equalsIgnoreCase("y");
            }
            double price = toppingPrice(category, plate.getSize(), isExtra);
            Topping topping = new Topping(name, category, price);
            if (isExtra) topping.setExtra(true);
            plate.addTopping(topping);
            System.out.println("Added: " + topping);
            System.out.println("Add another or 0 to continue:");
        }
    }

    private double toppingPrice(ToppingCategory category, Size size, boolean isExtra) {
        if (category == ToppingCategory.MEAT) {
            return isExtra
                ? switch (size) { case SMALL -> 4.00; case MEDIUM -> 8.00; case LARGE -> 12.00; }
                : switch (size) { case SMALL -> 8.00; case MEDIUM -> 15.00; case LARGE -> 25.00; };
        }
        if (category == ToppingCategory.PREMIUM) {
            return isExtra
                ? switch (size) { case SMALL -> 3.00; case MEDIUM -> 5.00; case LARGE -> 8.00; }
                : switch (size) { case SMALL -> 6.00; case MEDIUM -> 10.00; case LARGE -> 16.00; };
        }
        return 0.0;
    }
}
