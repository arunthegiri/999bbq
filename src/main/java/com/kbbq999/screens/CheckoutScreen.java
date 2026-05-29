package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.menu.Order;
import com.kbbq999.service.ReceiptService;

public class CheckoutScreen {

    private Scanner scanner;
    private Order order;
    private ReceiptService receiptService;

    public CheckoutScreen(Scanner scanner, Order order, ReceiptService receiptService) {
        this.scanner = scanner;
        this.order = order;
        this.receiptService = receiptService;
    }

    public void display() {
        showOrderDetails();
        System.out.println("================================");
        System.out.println("1) Confirm Order");
        System.out.println("0) Cancel Order");
    }

    public void showOrderDetails() {
        System.out.println("================================");
        System.out.println("         Order Summary");
        System.out.println("================================");
        order.displayOrder();
    }

    public void confirmOrder() {
        receiptService.saveReceipt(order);
        System.out.println("Order confirmed! Receipt saved to receipts/");
    }

    public void cancelOrder() {
        System.out.println("Order cancelled.");
    }

    public int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
