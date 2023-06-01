package pl.sklep.item.product;

import pl.sklep.item.Product;

public class AGD extends Product {

    private boolean isBig;

    public AGD(String name, int number, int cost, boolean isBig) {
        super(name, cost, number);
        this.isBig = isBig;
    }

    public AGD(String[] vars){
        super(vars);
    }


    public boolean isBig() {
        return isBig;
    }

    public void setBig(boolean big) {
        isBig = big;
    }
}