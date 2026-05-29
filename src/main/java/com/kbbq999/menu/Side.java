package com.kbbq999.menu;

import com.kbbq999.enums.Size;

public class Side extends MenuItem {

    private String sideType;

    public Side(String sideType) {
        super(sideType, null, 0.0);
        this.sideType = sideType;
    }

    public String getSideType() { return sideType; }
    public double getPrice() { return 0.0; }
    public void addToOrder() {}
    public boolean validate() { return false; }
    public String fetchAIDescription() { return ""; }
    public String getAIHint() { return ""; }
    public String toString() { return ""; }
}
