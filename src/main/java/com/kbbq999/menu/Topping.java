package com.kbbq999.menu;

import com.kbbq999.enums.ToppingCategory;

public class Topping {

    private String name;
    private ToppingCategory category;
    private boolean isExtra;
    private double price;

    public Topping(String name, ToppingCategory category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.isExtra = false;
    }

    public String getName() { return name; }
    public ToppingCategory getCategory() { return category; }

    public double getPrice() {
        if (category == ToppingCategory.MEAT || category == ToppingCategory.PREMIUM) {
            return price;
        }
        return 0.0;
    }

    public boolean isExtra() { return isExtra; }
    public void setExtra(boolean isExtra) { this.isExtra = isExtra; }

    public double getExtraPrice() {
        return isExtra ? price : 0.0;
    }

    public String toString() {
        return isExtra ? name + " (extra)" : name;
    }
}
