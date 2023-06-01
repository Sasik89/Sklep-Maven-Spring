package pl.sklep.item.product;

import pl.sklep.item.Product;

public class RTV extends Product {

    private boolean hasWiFIacces;

    public RTV(String name, int number, int cost, boolean hasWiFIacces) {
        super(name, cost, number);
        this.hasWiFIacces = hasWiFIacces;
    }

    public RTV(String[] vars) {
        super(vars);
    }

    public boolean ishasWiFIacces() {
        return hasWiFIacces;
    }

    public void sethasWiFIacces(boolean hasWiFIacces) {
        this.hasWiFIacces = hasWiFIacces;
    }
}