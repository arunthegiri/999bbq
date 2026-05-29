package com.kbbq999.screens;

import java.util.Scanner;
import com.kbbq999.menu.Order;
import com.kbbq999.menu.BBQPlate;
import com.kbbq999.menu.MenuItem;
import com.kbbq999.enums.MealType;
import com.kbbq999.enums.Size;
import com.kbbq999.service.GeminiSession;
import com.kbbq999.service.GeminiDescriptionService;

public class AddItemScreen {

    private Scanner scanner;
    private Order order;
    private GeminiDescriptionService geminiService;
    private GeminiSession currentSession;

    public AddItemScreen(Scanner scanner, Order order, GeminiDescriptionService geminiService) {
        this.scanner = scanner;
        this.order = order;
        this.geminiService = geminiService;
        this.currentSession = null;
    }

    public void display() {}
    public void showItemOptions(MenuItem item) {}
    public void triggerTellMeMore(MenuItem item) {}
    public void handleGeminiLoop(GeminiSession session) {}
    public BBQPlate buildPlate() { return null; }
    public Size selectSize() { return null; }
    public MealType selectMealType() { return null; }
    public void selectToppings(BBQPlate plate) {}
    public int getUserChoice() { return 0; }
}
