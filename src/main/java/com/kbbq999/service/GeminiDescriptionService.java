package com.kbbq999.service;

import com.kbbq999.interfaces.IAIDescribable;

public class GeminiDescriptionService implements IAIDescribable {

    private String apiKey;
    private static final String ENDPOINT = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent";

    public GeminiDescriptionService(String apiKey) {
        this.apiKey = apiKey;
    }

    public String fetchAIDescription() { return ""; }
    public String getAIHint() { return ""; }
    public String describe(String itemName) { return ""; }
    public String getMenuHint(String name) { return ""; }
}
