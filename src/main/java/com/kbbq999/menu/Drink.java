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
    public double getPrice() { return 0.0; }
    public void addToOrder() {}
    public boolean validate() { return false; }
    public String fetchAIDescription() { return ""; }
    public String getAIHint() { return ""; }
    public String toString() { return ""; }
}
