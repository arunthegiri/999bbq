package com.kbbq999.service;

import com.kbbq999.menu.Order;
import com.kbbq999.menu.MenuItem;
import com.kbbq999.menu.Drink;
import com.kbbq999.menu.Side;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptService {

    private static final String RECEIPT_DIR = "receipts/";
    private static final String DATE_FORMAT = "yyyyMMdd-HHmmss";

    public String formatFileName(Order order) {
        return order.getOrderTime()
            .format(DateTimeFormatter.ofPattern(DATE_FORMAT)) + ".txt";
    }

    public String formatReceipt(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 999BBQ Receipt ===\n");
        sb.append("Date: ")
          .append(order.getOrderTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")))
          .append("\n");

        if (!order.getItems().isEmpty()) {
            sb.append("\n--- Plates ---\n");
            for (MenuItem item : order.getItems()) {
                sb.append(item).append("\n");
            }
        }

        if (!order.getDrinks().isEmpty()) {
            sb.append("\n--- Drinks ---\n");
            for (Drink drink : order.getDrinks()) {
                sb.append(drink).append("\n");
            }
        }

        if (!order.getSides().isEmpty()) {
            sb.append("\n--- Sides ---\n");
            for (Side side : order.getSides()) {
                sb.append(side).append("\n");
            }
        }

        sb.append(String.format("%nTotal: $%.2f%n", order.getTotal()));
        return sb.toString();
    }

    public void saveReceipt(Order order) {
        File dir = new File(RECEIPT_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String filePath = RECEIPT_DIR + formatFileName(order);
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(formatReceipt(order));
        } catch (IOException e) {
            System.err.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
