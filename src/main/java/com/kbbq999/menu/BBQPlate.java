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

    public void addTopping(Topping topping) {}
    public List<Topping> getToppings() { return toppings; }
    public MealType getMealType() { return mealType; }
    public boolean isAllYouCanEat() { return isAllYouCanEat; }
    public void toggleAllYouCanEat() {}
    public double getPrice() { return 0.0; }
    public void addToOrder() {}
    public boolean validate() { return false; }
    public String fetchAIDescription() { return ""; }
    public String getAIHint() { return ""; }
    public String toString() { return ""; }
}
