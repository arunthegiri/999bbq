package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.menu.Order;
import com.kbbq999.menu.Drink;
import com.kbbq999.enums.DrinkType;
import com.kbbq999.enums.Size;

public class AddDrinkScreen {

    private Scanner scanner;
    private Order order;

    public AddDrinkScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {}
    public DrinkType selectDrinkType() { return null; }
    public Size selectSize() { return null; }
    public Drink buildDrink() { return null; }
    public int getUserChoice() { return 0; }
}
