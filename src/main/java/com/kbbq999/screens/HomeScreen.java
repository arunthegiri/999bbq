package com.kbbq999.screens;

import java.util.Scanner;

public class HomeScreen {

    private Scanner scanner;

    public HomeScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public void display() {
        System.out.println("================================");
        System.out.println("     Welcome to 999BBQ 🔥");
        System.out.println("  High-End Korean BBQ Experience");
        System.out.println("================================");
        System.out.println();
        System.out.println("📋 OUR MENU");
        System.out.println("================================");
        System.out.println();
        System.out.println("🥩 MEAL TYPES");
        System.out.println("  • KBBQ        • SOUP");
        System.out.println("  • HOTPOT      • OMAKASE");
        System.out.println();
        System.out.println("📏 SIZES & BASE PRICES");
        System.out.println("  • Small  (Solo)     - $45.00");
        System.out.println("  • Medium (For 2)    - $75.00");
        System.out.println("  • Large  (For 4)    - $120.00");
        System.out.println();
        System.out.println("🥩 PREMIUM MEATS (+per size)");
        System.out.println("  • Australian Wagyu  • Brisket");
        System.out.println("  • Galbi             • Pork Belly");
        System.out.println("  • Bulgogi           • Spicy Bulgogi");
        System.out.println();
        System.out.println("⭐ PREMIUM TOPPINGS");
        System.out.println("  • Salmon Roe        • Corn Cheese");
        System.out.println("  • Snow Crab         • Steamed Egg");
        System.out.println();
        System.out.println("🥗 REGULAR TOPPINGS (included)");
        System.out.println("  • Kimchi            • Bean Sprouts");
        System.out.println("  • Spinach           • Mushrooms");
        System.out.println("  • Corn              • Cucumber");
        System.out.println("  • Onion             • Perilla Leaf");
        System.out.println("  • Radish");
        System.out.println();
        System.out.println("🫙 CONDIMENTS (included)");
        System.out.println("  • Gochujang         • Ssamjang");
        System.out.println("  • Sesame Oil        • Garlic Butter");
        System.out.println("  • Yuzu Ponzu        • Doenjang");
        System.out.println();
        System.out.println("🥤 DRINKS");
        System.out.println("  • Small $8  • Medium $12  • Large $16");
        System.out.println("  • Soju, Makgeolli, Barley Tea,");
        System.out.println("    Sparkling Water, Coke, Juice");
        System.out.println();
        System.out.println("🍚 SIDES - $8.00");
        System.out.println("  • Steamed Rice      • Kimchi Jjigae");
        System.out.println();
        System.out.println("✨ SPECIAL: All-You-Can-Eat +$35.00");
        System.out.println();
        System.out.println("================================");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
        System.out.println("================================");
    }

    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void handleInput(int choice) {
        if (choice == 0) {
            System.out.println("Goodbye from 999BBQ! 👋");
        }
    }
}
