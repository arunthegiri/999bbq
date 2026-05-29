package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.menu.Order;
import com.kbbq999.menu.Side;

public class AddSideScreen {

    private Scanner scanner;
    private Order order;

    public AddSideScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {}
    public Side buildSide() { return null; }
    public int getUserChoice() { return 0; }
}
