package com.kbbq999;

import java.util.Scanner;
import com.kbbq999.menu.Drink;
import com.kbbq999.menu.Order;
import com.kbbq999.menu.Side;
import com.kbbq999.screens.AddDrinkScreen;
import com.kbbq999.screens.AddItemScreen;
import com.kbbq999.screens.AddSideScreen;
import com.kbbq999.screens.CheckoutScreen;
import com.kbbq999.screens.HomeScreen;
import com.kbbq999.screens.OrderScreen;
import com.kbbq999.service.ReceiptService;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReceiptService receiptService = new ReceiptService();

        while (true) {
            HomeScreen home = new HomeScreen(scanner);
            home.display();
            int homeChoice = home.getUserChoice();

            if (homeChoice == 0) {
                System.out.println("Goodbye from 999BBQ! 👋");
                break;
            }
            if (homeChoice != 1) continue;

            Order order = new Order();
            OrderScreen orderScreen = new OrderScreen(scanner, order);
            boolean orderDone = false;

            while (!orderDone) {
                orderScreen.display();
                int choice = orderScreen.getUserChoice();

                switch (choice) {
                    case 1 -> {
                        AddItemScreen addItem = new AddItemScreen(scanner, order);
                        addItem.buildPlate();
                    }
                    case 2 -> {
                        AddDrinkScreen addDrink = new AddDrinkScreen(scanner, order);
                        Drink drink = addDrink.buildDrink();
                        if (drink != null) order.addDrink(drink);
                    }
                    case 3 -> {
                        AddSideScreen addSide = new AddSideScreen(scanner, order);
                        Side side = addSide.buildSide();
                        if (side != null) order.addSide(side);
                    }
                    case 4 -> {
                        CheckoutScreen checkout = new CheckoutScreen(scanner, order, receiptService);
                        checkout.display();
                        int checkoutChoice = checkout.getUserChoice();
                        if (checkoutChoice == 1) {
                            checkout.confirmOrder();
                        } else {
                            checkout.cancelOrder();
                        }
                        orderDone = true;
                    }
                    case 0 -> {
                        System.out.println("Order cancelled.");
                        orderDone = true;
                    }
                }
            }
        }

        scanner.close();
    }
}
