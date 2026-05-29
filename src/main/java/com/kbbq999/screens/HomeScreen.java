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
        System.out.println("================================");
        System.out.println("1) New Order");
        System.out.println("0) Exit");
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
