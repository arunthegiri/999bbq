package com.kbbq999.menu;

import com.kbbq999.enums.Size;
import com.kbbq999.interfaces.IPriceable;
import com.kbbq999.interfaces.IDescribable;
import com.kbbq999.interfaces.IOrderable;
import com.kbbq999.interfaces.IAIDescribable;

public abstract class MenuItem implements IPriceable, IDescribable, IOrderable, IAIDescribable {

    protected String name;
    protected Size size;
    protected double price;
    protected String description;

    public MenuItem(String name, Size size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getName() { return name; }
    public Size getSize() { return size; }
    public double getPrice() { return 0.0; }
    public String getDescription() { return ""; }
    public abstract void addToOrder();
    public abstract boolean validate();
    public abstract String fetchAIDescription();
    public abstract String getAIHint();
    public String toString() { return ""; }
}
