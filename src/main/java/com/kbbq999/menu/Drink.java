package com.kbbq999.menu;

import com.kbbq999.enums.Size;
import com.kbbq999.enums.DrinkType;

public class Drink extends MenuItem {

    private DrinkType drinkType;

    public Drink(DrinkType drinkType, Size size) {
        super(drinkType.name(), size, 0.0);
        this.drinkType = drinkType;
    }

    public DrinkType getDrinkType() { return drinkType; }

    public double getPrice() {
        return switch (size) {
            case SMALL  -> 8.00;
            case MEDIUM -> 12.00;
            case LARGE  -> 16.00;
        };
    }

    public void addToOrder() {}

    public boolean validate() {
        return drinkType != null;
    }

    public String fetchAIDescription() { return ""; }
    public String getAIHint() { return ""; }

    public String toString() {
        return String.format("%s - %s - $%.2f", drinkType, size, getPrice());
    }
}
