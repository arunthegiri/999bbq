package com.kbbq999.service;

import com.kbbq999.interfaces.IAIDescribable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeminiDescriptionService implements IAIDescribable {

    private static final String SYSTEM_PROMPT =
        "You are a friendly Korean BBQ restaurant guide for 999BBQ, a high-end Korean BBQ restaurant. " +
        "Help customers understand Korean BBQ dishes, ingredients and culture in a warm, approachable way. " +
        "Keep responses under 3 sentences.";

    private static final String BASE_URL =
        "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=";

    private String apiKey;

    public GeminiDescriptionService(String apiKey) {
        this.apiKey = (apiKey != null && !apiKey.isEmpty())
            ? apiKey
            : System.getenv("GEMINI_API_KEY");
    }

    public String describe(String prompt) {
        if (apiKey == null || apiKey.isEmpty()) return "";
        String body = buildRequestBody(prompt);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + apiKey))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
            HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
            return extractText(response.body());
        } catch (Exception e) {
            return "";
        }
    }

    public String getMenuHint(String name) {
        return describe(name);
    }

    public String fetchAIDescription() {
        return describe("999BBQ Korean BBQ Restaurant");
    }

    public String getAIHint() {
        return describe("999BBQ menu");
    }

    private String buildRequestBody(String prompt) {
        return "{"
            + "\"systemInstruction\":{\"parts\":[{\"text\":\"" + escapeJson(SYSTEM_PROMPT) + "\"}]},"
            + "\"contents\":[{\"parts\":[{\"text\":\"" + escapeJson(prompt) + "\"}]}]"
            + "}";
    }

    private String escapeJson(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    private String extractText(String json) {
        String marker = "\"text\":\"";
        int start = json.indexOf(marker);
        if (start == -1) {
            marker = "\"text\": \"";
            start = json.indexOf(marker);
        }
        if (start == -1) return "";
        start += marker.length();
        StringBuilder result = new StringBuilder();
        int i = start;
        while (i < json.length()) {
            char c = json.charAt(i);
            if (c == '\\' && i + 1 < json.length()) {
                char next = json.charAt(i + 1);
                switch (next) {
                    case '"'  -> result.append('"');
                    case 'n'  -> result.append('\n');
                    case 'r'  -> result.append('\r');
                    case 't'  -> result.append('\t');
                    case '\\' -> result.append('\\');
                    default   -> result.append(next);
                }
                i += 2;
            } else if (c == '"') {
                break;
            } else {
                result.append(c);
                i++;
            }
        }
        return result.toString();
    }
}
