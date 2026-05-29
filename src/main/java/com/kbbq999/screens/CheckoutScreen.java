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

    public void display() {}
    public void showOrderDetails() {}
    public void confirmOrder() {}
    public void cancelOrder() {}
    public int getUserChoice() { return 0; }
}
