package com.kbbq999.menu;

import com.kbbq999.enums.Size;
import com.kbbq999.enums.MealType;
import com.kbbq999.enums.ToppingCategory;
import java.util.ArrayList;
import java.util.List;

public class BBQPlate extends MenuItem {

    private MealType mealType;
    private List<Topping> toppings;
    private boolean isAllYouCanEat;

    public BBQPlate(String name, Size size, MealType mealType) {
        super(name, size, 0.0);
        this.mealType = mealType;
        this.toppings = new ArrayList<>();
        this.isAllYouCanEat = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public List<Topping> getToppings() { return toppings; }
    public MealType getMealType() { return mealType; }
    public boolean isAllYouCanEat() { return isAllYouCanEat; }

    public void toggleAllYouCanEat() {
        isAllYouCanEat = !isAllYouCanEat;
    }

    public double getPrice() {
        double base = switch (size) {
            case SMALL  -> 45.00;
            case MEDIUM -> 75.00;
            case LARGE  -> 120.00;
        };
        double toppingTotal = toppings.stream().mapToDouble(Topping::getPrice).sum();
        double ayce = isAllYouCanEat ? 35.00 : 0.0;
        return base + toppingTotal + ayce;
    }

    public void addToOrder() {}

    public boolean validate() {
        return mealType != null && size != null;
    }

    public String fetchAIDescription() { return ""; }
    public String getAIHint() { return ""; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(size).append(" | ").append(mealType).append(")");
        if (!toppings.isEmpty()) {
            sb.append("\n  Toppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(toppings.get(i));
            }
        }
        if (isAllYouCanEat) sb.append("\n  AYCE: +$35.00");
        sb.append(String.format("%n  Price: $%.2f", getPrice()));
        return sb.toString();
    }
}
