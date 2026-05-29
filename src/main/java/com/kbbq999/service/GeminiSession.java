package com.kbbq999.service;

import com.kbbq999.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class GeminiSession {

    private MenuItem currentItem;
    private boolean isActive;
    private List<String> conversationHistory;

    public GeminiSession(MenuItem item) {
        this.currentItem = item;
        this.isActive = false;
        this.conversationHistory = new ArrayList<>();
    }

    public void start() {}
    public String ask(String userQuestion) { return ""; }
    public void close() {}
    public boolean isActive() { return isActive; }
    public MenuItem getCurrentItem() { return currentItem; }
}
