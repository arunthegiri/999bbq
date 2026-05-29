package com.kbbq999.service;

import com.kbbq999.menu.Order;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptService {

    private static final String RECEIPT_DIR = "receipts/";
    private static final String DATE_FORMAT = "yyyyMMdd-HHmmss";

    public void saveReceipt(Order order) {}
    public String formatFileName(Order order) { return ""; }
    public String formatReceipt(Order order) { return ""; }
}
