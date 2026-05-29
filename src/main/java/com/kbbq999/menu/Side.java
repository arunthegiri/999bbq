package com.kbbq999.menu;

public class Side extends MenuItem {

    private String sideType;

    public Side(String sideType) {
        super(sideType, null, 0.0);
        this.sideType = sideType;
    }

    public String getSideType() { return sideType; }

    public double getPrice() {
        return 8.00;
    }

    public void addToOrder() {}

    public boolean validate() {
        return sideType != null;
    }

    public String fetchAIDescription() { return ""; }
    public String getAIHint() { return ""; }

    public String toString() {
        return sideType + " - $8.00";
    }
}
