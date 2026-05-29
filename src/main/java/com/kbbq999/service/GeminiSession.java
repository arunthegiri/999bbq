package com.kbbq999.service;

import com.kbbq999.menu.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class GeminiSession {

    private MenuItem currentItem;
    private boolean isActive;
    private List<String> conversationHistory;
    private GeminiDescriptionService geminiService;

    public GeminiSession(MenuItem item) {
        this.currentItem = item;
        this.isActive = false;
        this.conversationHistory = new ArrayList<>();
        this.geminiService = new GeminiDescriptionService(null);
    }

    public void start() {
        isActive = true;
    }

    public String ask(String userQuestion) {
        String prompt = currentItem.getName() + " " + userQuestion;
        String response = geminiService.describe(prompt);
        conversationHistory.add("Q: " + userQuestion);
        conversationHistory.add("A: " + response);
        return response;
    }

    public void close() {
        isActive = false;
        conversationHistory.clear();
    }

    public boolean isActive() { return isActive; }
    public MenuItem getCurrentItem() { return currentItem; }
}
